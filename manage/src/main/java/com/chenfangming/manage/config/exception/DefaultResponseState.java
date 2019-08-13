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
public enum DefaultResponseState implements ResponseState {

    /** 通用成功 **/
    SUCCESS("成功"),
    /** 通用失败 **/
    FAIL("失败"),
    /** 通用异常 **/
    EXCEPTION("异常"),
    /** 请求路径不存在 **/
    PATH_NOT_FOUND("请求路径不存在"),
    /** 未登录 **/
    NO_AUTHENTICATION("未认证"),
    /** 权限不足 **/
    NO_AUTHORIZE("未授权"),
    /** Token已过期 **/
    AUTHENTICATION_EXPIRED("认证已过期"),
    /** 请求参数格式不正确 **/
    BAD_REQUEST_ARGS("请求参数格式不正确");

    /** 提示信息 **/
    private String message;

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
