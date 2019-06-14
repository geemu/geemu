package com.chenfangming.common.config.exception;

import com.chenfangming.common.domain.DefaultResponseStatus;
import com.chenfangming.common.domain.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 异常控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-14 22:39
 */
@Slf4j
@RestControllerAdvice
public class BizExceptionHandle {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Void> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        log.info("不支持的请求方法:", ex);
        return new ResponseEntity<>(DefaultResponseStatus.METHOD_NOT_SUPPORT);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Void> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {
        log.info("不支持的请求方法:", ex);
        return new ResponseEntity<>(DefaultResponseStatus.METHOD_NOT_SUPPORT);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Void> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        log.info("请求路径不存在:", ex);
        return new ResponseEntity<>(DefaultResponseStatus.PATH_NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handleException(Exception ex) {
        log.error("后台未知异常:", ex);
        return new ResponseEntity<>(DefaultResponseStatus.EXCEPTION);
    }


}
