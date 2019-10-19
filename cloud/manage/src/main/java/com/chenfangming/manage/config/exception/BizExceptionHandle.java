package com.chenfangming.manage.config.exception;

import com.chenfangming.manage.config.exception.BaseResponse.BaseResponseState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    /**
     * 自定义异常
     * @param ex 异常
     * @return JSON视图
     */
    @ExceptionHandler(BizException.class)
    public BaseResponse<Void> handle(BizException ex) {
        log.info("自定义异常:", ex);
        return new BaseResponse<>(ex);
    }

    /**
     * 请求路径不存在
     * @param ex 异常
     * @return JSON视图
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseResponse<Void> handle(NoHandlerFoundException ex) {
        log.info("请求路径不存在:", ex);
        return new BaseResponse<>(BaseResponseState.PATH_NOF_FOUND);
    }

    /**
     * 500未知异常
     * @param ex 异常
     * @return JSON视图
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<Void> handle(Exception ex) {
        log.error("后台未知异常:", ex);
        return new BaseResponse<>(BaseResponseState.INTERNAL_SERVER_ERROR);
    }

}
