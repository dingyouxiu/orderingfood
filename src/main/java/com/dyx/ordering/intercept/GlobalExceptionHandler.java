package com.dyx.ordering.intercept;

import com.dyx.ordering.exception.ServiceException;
import com.dyx.ordering.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public Result<String> handleResourceNotFoundException(ServiceException serviceException) {
        return Result.error(serviceException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<String> handleGlobalException(Exception exception) {
        return Result.error(exception.getMessage());
    }

}
