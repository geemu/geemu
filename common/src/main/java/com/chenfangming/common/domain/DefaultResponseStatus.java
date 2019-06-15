package com.chenfangming.common.domain;

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
    SUCCESS(0, "成功"),
    /** 通用失败 自定义业务失败 **/
    FAIL(1, "失败"),
    BAD_REQUEST(2, "请求参数异常"),
    INTERNAL_SERVER_ERROR(3, "系统未知异常"),
    /** 未登录 **/
    NO_AUTHENTICATION(4, "未认证"),
    /** 权限不足 **/
    NO_AUTHORIZE(5, "未授权"),
    /** Token已过期 **/
    TOKEN_EXPIRED(6, "认证已过期"),
    /** Refresh Token已过期 **/
    REFRESH_TOKEN_EXPIRED(7, "认证已过期");


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
