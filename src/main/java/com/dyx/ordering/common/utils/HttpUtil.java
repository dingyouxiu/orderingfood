/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dyx.ordering.common.utils;

import com.dyx.ordering.common.constant.BaseConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

/**
 * HTTP utilities class with secure SSL context.
 */
@Slf4j
public class HttpUtil {

    private static final PoolingHttpClientConnectionManager cm;
    private static final SSLContext ctx;
    private static final SSLConnectionSocketFactory socketFactory;
    private static final RequestConfig requestConfig;

    static {
        try {
            // Use default SSL context which includes standard certificate validation
            ctx = SSLContext.getDefault();
        } catch (NoSuchAlgorithmException e) {
            log.error("Failed to get default SSLContext", e);
            throw new RuntimeException("Failed to get default SSLContext", e);
        }

        socketFactory = new SSLConnectionSocketFactory(ctx, new DefaultHostnameVerifier());

        // Set timeout, request time, socket timeout
        requestConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .setExpectContinueEnabled(Boolean.TRUE)
                .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST, AuthSchemes.SPNEGO))
                .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC, AuthSchemes.SPNEGO))
                .setConnectTimeout(BaseConstants.HTTP_CONNECT_TIMEOUT)
                .setSocketTimeout(BaseConstants.SOCKET_TIMEOUT)
                .setConnectionRequestTimeout(BaseConstants.HTTP_CONNECTION_REQUEST_TIMEOUT)
                .setRedirectsEnabled(true)
                .build();

        cm = new PoolingHttpClientConnectionManager(
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", PlainConnectionSocketFactory.INSTANCE)
                        .register("https", socketFactory)
                        .build());

        cm.setDefaultMaxPerRoute(60);
        cm.setMaxTotal(100);
    }

    // Private constructor to prevent instantiation
    private HttpUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // Returns a singleton instance of the HTTP client
    public static CloseableHttpClient getInstance() {
        return HttpClientInstance.httpClient;
    }

    private static class HttpClientInstance {

        private static final CloseableHttpClient httpClient = getHttpClientBuilder().build();
    }

    // Builds and returns an HttpClient with the custom configuration
    public static HttpClientBuilder getHttpClientBuilder() {
        return HttpClients.custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(requestConfig);
    }

    /**
     * Executes a GET request with specific header and returns the response content as a string with specific charset.
     *
     * @param url The URL to send the GET request to
     * @param headers The headers to send with the GET request
     * @param charset The charset of response content
     * @return The response content as a string
     */
    public static String get(String url,
                             Map<String, String> headers,
                             String charset) {
        CloseableHttpClient httpclient = HttpUtil.getInstance();
        HttpGet httpGet = new HttpGet(url);
        if (MapUtils.isNotEmpty(headers)) {
            headers.forEach(httpGet::setHeader);
        }
        return getResponseContentString(httpGet, httpclient, charset);
    }

    /**
     * Executes a GET request with url and returns the response content as a string.
     *
     * @param url The URL to send the GET request to
     * @return The response content as a string
     */
    public static String get(String url) {
        return get(url, null, BaseConstants.UTF_8);
    }

    /**
     * Executes a GET request with url and returns the response content as a string with specific charset.
     *
     * @param url The URL to send the GET request to
     * @return The response content as a string
     */
    public static String get(String url, String charset) {
        return get(url, null, charset);
    }

    public static String post(String url, Map<String, String> headers, String params) {
        String result = "";
        CloseableHttpClient httpClient = HttpUtil.getInstance();

        HttpPost httpPost = new HttpPost(url);
        try {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
            httpPost.addHeader("Content-type", "application/json; charset=utf-8");
            httpPost.setHeader("Accept", "application/json");
            if (StringUtils.isNotBlank(params)) {
                httpPost.setEntity(new StringEntity(params, StandardCharsets.UTF_8));
            }
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);// "GB2312"
                log.info("http succeed with results: {}", result);
            } else {
                log.error("http terminated,response: {}", response);
            }
        } catch (IllegalArgumentException ie) {
            log.error("http terminated: {}", ie.getMessage());
        } catch (Exception he) {
            log.error("http terminated: ", he);
        }
        return result;
    }

    /**
     * Gets the response content from an executed HttpGet request.
     *
     * @param httpGet     The HttpGet request to execute
     * @param httpClient  The HttpClient to use for the request
     * @return The response content as a string
     */
    public static String getResponseContentString(HttpGet httpGet,
                                                  CloseableHttpClient httpClient,
                                                  String charset) {
        if (httpGet == null || httpClient == null) {
            log.error("HttpGet or HttpClient parameter is null");
            return null;
        }

        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            // Check if the response status is 200 (OK)
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                log.error("HTTP GET request to {} returned status code: {}", httpGet.getURI(),
                        response.getStatusLine().getStatusCode());
                return null;
            }

            HttpEntity entity = response.getEntity();
            return entity != null ? EntityUtils.toString(entity, charset) : null;
        } catch (IOException e) {
            log.error("Error executing HTTP GET request", e);
            return null;
        } finally {
            httpGet.releaseConnection();
        }
    }
}
