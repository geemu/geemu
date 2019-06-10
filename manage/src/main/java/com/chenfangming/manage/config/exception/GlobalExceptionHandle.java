package com.chenfangming.manage.config.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-10 21:22
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(Exception.class)
    public void handlerException(Exception ex) {
        log.error("后台未知异常:", ex);
    }

}
