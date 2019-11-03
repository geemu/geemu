package com.chenfangming.manage.config.exception;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 基础封装返回体
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-10-27 10:18
 */
@Slf4j
@Getter
@ToString
@EqualsAndHashCode
public class BaseResponse<T> {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

    /** 返回状态码 **/
    private Integer code;
    /** 返回提示信息 **/
    private String message;
    /** 返回数据 **/
    private T data;

    /**
     * 自定义code、message、data
     * @param code code
     * @param message message
     * @param data data
     */
    public BaseResponse(ResponseState code, String message, T data) {
        this(code.getCode(), message, data);
    }

    /**
     * 构造
     * @param code 返回状态码
     * @param message 返回提示信息
     * @param data 返回数据
     */
    private BaseResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 自定义code、message、data
     * @param state code、message
     * @param data data
     */
    public BaseResponse(ResponseState state, T data) {
        this(state.getCode(), state.getMessage(), data);
    }

    /**
     * 自定义code、message
     * @param code code
     * @param message message
     */
    public BaseResponse(ResponseState code, String message) {
        this(code.getCode(), code.getMessage(), null);
    }

    /**
     * 自定义code、message
     * @param state code、message
     */
    public BaseResponse(ResponseState state) {
        this(state.getCode(), state.getMessage(), null);
    }

    /**
     * 自定义data
     * @param data data
     */
    public BaseResponse(T data) {
        this(BaseResponseState.SUCCESS.getCode(), BaseResponseState.SUCCESS.getMessage(), data);
    }

    /**
     * 自定义code、message
     * @param ex code、message
     */
    public BaseResponse(BizException ex) {
        this(ex.getCode(), ex.getMessage(), null);
    }

    /**
     * 返回状态码、返回提示信息
     */
    @Getter
    @ToString
    @AllArgsConstructor
    public enum BaseResponseState implements ResponseState {
        //--------------------公共返回Begin--------------------//
        /** 通用成功 **/
        SUCCESS(0, "成功"),
        /** 客户端请求异常、请求参数校验不通过等 **/
        BAD_REQUEST(1, "客户端请求异常"),
        /** 未登录 **/
        NO_LOGIN(2, "未登录"),
        /** 权限不足 **/
        FORBIDDEN(3, "权限不足"),
        /** 请求路径不存在 **/
        PATH_NOF_FOUND(4, "请求路径不存在"),
        /** 通用服务端异常 **/
        INTERNAL_SERVER_ERROR(5, "服务器异常"),
        //--------------------公共返回End--------------------//

        /** 用户不存在 **/
        USER_NOT_EXISTED(6, "用户不存在"),
        /** 用户已存在 **/
        USER_EXISTED(7, "用户已存在"),
        /** 密码错误 **/
        INVALID_PASSWORD(8, "密码错误"),
        /** 用户被禁用 **/
        USER_LOCKED(9, "用户被禁用");

        /** 返回状态码 **/
        private Integer code;
        /** 返回提示信息 **/
        private String message;

    }

}
