package com.chenfangming.common.config.exception;

import com.chenfangming.common.domain.DefaultResponseStatus;
import com.chenfangming.common.domain.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-14 22:39
 */
@Slf4j
@RestControllerAdvice
public class BizExceptionHandle {

    /**
     * 400方法参数校验不通过异常、需要区别对待的异常
     * 前端校验会防止出现这种异常,只要用户按规矩走前端JS请求是不会出现这种情况的，
     * 因此这种异常不需要明确提示哪里错了,后台记录以下就可以了。
     * @param ex 异常
     * @return JSON视图
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ResponseEntity<Void> handle(MethodArgumentNotValidException ex) {
        log.warn("方法参数校验不通过:", ex);
        return new ResponseEntity<>(DefaultResponseStatus.BAD_REQUEST);
    }

    /**
     * 400参数绑定异常、需要区别对待的异常
     * 前端校验会防止出现这种异常,只要用户按规矩走前端JS请求是不会出现这种情况的，
     * 因此这种异常不需要明确提示哪里错了,后台记录以下就可以了。
     * @param ex 异常
     * @return JSON视图
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ResponseEntity<Void> handle(BindException ex) {
        log.warn("参数绑定异常:", ex);
        return new ResponseEntity<>(DefaultResponseStatus.BAD_REQUEST);
    }

    /**
     * 500未知异常、不需要区别对待的异常
     * @param ex 异常
     * @return JSON视图
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<Void> handle(Exception ex) {
        log.error("后台未知异常:", ex);
        return new ResponseEntity<>(DefaultResponseStatus.INTERNAL_SERVER_ERROR);
    }

}
