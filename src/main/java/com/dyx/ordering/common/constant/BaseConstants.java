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

package com.dyx.ordering.common.constant;

public final class BaseConstants {

    private BaseConstants() {
        throw new UnsupportedOperationException("Construct Constants");
    }

    /**
     * HTTP 连接超时时间
     */
    public static final int HTTP_CONNECT_TIMEOUT = 60 * 1000;

    /**
     * HTTP 连接请求超时时间
     */
    public static final int HTTP_CONNECTION_REQUEST_TIMEOUT = 60 * 1000;

    /**
     * HTTP 长连接超时时间
     */
    public static final int SOCKET_TIMEOUT = 60 * 1000;

    /**
     * UTF-8
     */
    public static final String UTF_8 = "UTF-8";

    /**
     * 获取取餐吗失败重试次数
     */
    public static final Integer RETRY_NUMBER = 5;
}
