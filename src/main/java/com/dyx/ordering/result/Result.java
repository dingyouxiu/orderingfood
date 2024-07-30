package com.dyx.ordering.result;

import com.dyx.ordering.common.enums.BaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.text.MessageFormat;

@Data
public class Result<T> {

    @Schema(description = "RESULT_CODE")
    private Integer code;

    @Schema(description = "RESULT_MSG")
    private String msg;

    @Schema(description = "EXCEPTION_STACK")
    private String exceptionStack;

    @Schema(description = "RESULT_DATA")
    private T data;

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, Throwable throwable) {
        this.code = code;
        this.msg = msg;
        this.exceptionStack = ExceptionUtils.getStackTrace(throwable);
    }

    private Result(BaseStatus status) {
        if (status != null) {
            this.code = status.getCode();
            this.msg = status.getMsg();
        }
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(BaseStatus.SUCCESS.getCode(), BaseStatus.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public boolean isSuccess() {
        return this.isStatus(BaseStatus.SUCCESS);
    }

    public boolean isFailed() {
        return !this.isSuccess();
    }

    public boolean isStatus(BaseStatus status) {
        return this.code != null && this.code.equals(status.getCode());
    }

    public static <T> Result<T> error(BaseStatus status) {
        return new Result<>(status);
    }

    public static <T> Result<T> error(String errorMessage) {
        return new Result<>(BaseStatus.FAILED.getCode(), errorMessage);
    }

    public static <T> Result<T> error(BaseStatus status, Throwable throwable) {
        return new Result<>(status.getCode(), status.getMsg(), throwable);
    }

    public static <T> Result<T> errorWithArgs(BaseStatus status, Object... args) {
        return new Result<>(status.getCode(), MessageFormat.format(status.getMsg(), args));
    }

}
