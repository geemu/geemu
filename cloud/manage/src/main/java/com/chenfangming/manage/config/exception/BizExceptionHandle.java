package com.chenfangming.manage.config.exception;

import com.chenfangming.manage.config.exception.BaseResponse.BaseResponseState;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 异常控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-14 22:39
 */
@Slf4j
@RestControllerAdvice
public class BizExceptionHandle implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper objectMapper;

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

    /**
     * 是否支持
     * @param returnType returnType
     * @param converterType converterType
     * @return {@code true}支持、{@code false}不支持
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.getClass().isAssignableFrom(BaseResponse.class);
    }

    /**
     * 返回体重写
     * @param body body
     * @param returnType returnType
     * @param selectedContentType selectedContentType
     * @param selectedConverterType selectedConverterType
     * @param request request
     * @param response response
     * @return 重写后的返回体
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof BaseResponse) {
            return body;
        } else if (body instanceof String) {
            response.getHeaders().setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
            try {
                body = objectMapper.writeValueAsString(new BaseResponse<>(body));
            } catch (JsonProcessingException e) {
                log.error("转JSON异常:", e);
            }
            return body;
        }
        return new BaseResponse<>(body);
    }

}
