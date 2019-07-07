package com.chenfangming.manage.config.exception;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * 返回状态常量枚举
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-11-03 15:25
 */
@ToString
@AllArgsConstructor
public enum DefaultResponseStatus implements ResponseStatus {

    /** 通用成功 业务成功 **/
    SUCCESS(200, "成功"),
    /** 通用失败 自定义业务失败 **/
    FAIL(400, "失败"),
    PATH_NOT_FOUND(404, "请求路径不存在"),
    INTERNAL_SERVER_ERROR(500, "系统未知异常"),

    BAD_REQUEST(1, "请求参数异常"),
    /** 未登录 **/
    NO_AUTHENTICATION(2, "未认证"),
    /** 权限不足 **/
    NO_AUTHORIZE(3, "未授权"),
    /** Token已过期 **/
    TOKEN_EXPIRED(4, "认证已过期"),
    /** Refresh Token已过期 **/
    REFRESH_TOKEN_EXPIRED(5, "认证已过期");


    /** 状态码 **/
    private Integer code;
    /** 提示信息 **/
    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
