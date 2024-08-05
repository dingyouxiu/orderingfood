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

package com.dyx.ordering.common.enums;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.Optional;

/**
 * status enum
 */
public enum BaseStatus {

    SUCCESS(0, "success", "成功"),
    FAILED(1, "failed", "失败"),

    /**
     * 参数异常
     */
    PARAMETER_MISS(10000, "parameter is missing", "参数不能为空"),

    /**
     * 订单异常
     */
    ORDER_SAVE_ERROR(11000, "order save error", "订单保存异常"),
    ORDER_EDIT_ERROR(11001, "order edit error", "订单编辑异常"),
    ORDER_PURCHASE_ERROR(11002, "order purchase error", "下单失败"),
    ;

    private final int code;
    private final String enMsg;
    private final String zhMsg;

    BaseStatus(int code, String enMsg, String zhMsg) {
        this.code = code;
        this.enMsg = enMsg;
        this.zhMsg = zhMsg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        if (Locale.SIMPLIFIED_CHINESE.getLanguage().equals(LocaleContextHolder.getLocale().getLanguage())) {
            return this.zhMsg;
        } else {
            return this.enMsg;
        }
    }

    /**
     * Retrieve Status enum entity by status code.
     */
    public static Optional<BaseStatus> findStatusBy(int code) {
        for (BaseStatus status : BaseStatus.values()) {
            if (code == status.getCode()) {
                return Optional.of(status);
            }
        }
        return Optional.empty();
    }
}
