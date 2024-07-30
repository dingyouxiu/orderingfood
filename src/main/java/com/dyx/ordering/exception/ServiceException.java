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
package com.dyx.ordering.exception;

import com.dyx.ordering.common.enums.BaseStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.text.MessageFormat;

/**
 * service exception
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException {

    /**
     * code
     */
    private Integer code;

    public ServiceException() {
    }

    public ServiceException(BaseStatus status) {
        super(status.getMsg());
        this.code = status.getCode();
    }

    public ServiceException(BaseStatus status, Object... formatter) {
        super(MessageFormat.format(status.getMsg(), formatter));
        this.code = status.getCode();
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Exception cause) {
        super(message, cause);
    }

}


