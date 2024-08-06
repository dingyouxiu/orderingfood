package com.dyx.ordering.common.enums;

import java.util.Optional;

public enum OrderStatus {

    ADD_ONS(0, "加购"),
    NOT_APPRAISE(1, "待评价"),
    APPRAISE(2, "已评价"),
    ;

    private final int code;
    private final String zhMsg;

    OrderStatus(int code, String zhMsg) {
        this.code = code;
        this.zhMsg = zhMsg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.zhMsg;
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
