package com.chenfangming.manage.config;

import com.chenfangming.manage.domain.model.DefaultResponseStatus;
import com.chenfangming.manage.domain.model.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-10 21:22
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Void> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.info("不支持的请求方法:{}", e.getMessage());
        return new ResponseEntity<>(DefaultResponseStatus.METHOD_NOT_SUPPORT);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Void> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        log.info("不支持的请求方法:{}", e.getMessage());
        return new ResponseEntity<>(DefaultResponseStatus.METHOD_NOT_SUPPORT);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Void> handleNoHandlerFoundException(NoHandlerFoundException e) {
        log.info("请求路径不存在:{}", e.getMessage());
        return new ResponseEntity<>(DefaultResponseStatus.PATH_NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handleException(Exception ex) {
        log.error("后台未知异常:", ex);
        return new ResponseEntity<>(DefaultResponseStatus.EXCEPTION);
    }

}
