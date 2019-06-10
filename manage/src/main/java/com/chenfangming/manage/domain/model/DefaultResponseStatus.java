package com.chenfangming.manage.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 返回状态常量枚举
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-11-03 15:25
 */
@Getter
@ToString
@AllArgsConstructor
public enum DefaultResponseStatus implements ResponseStatus {
    /** 通用成功 业务成功 **/
    SUCCESS(0, "成功"),
    /** 通用失败 自定义业务失败 **/
    FAIL(1, "失败"),
    /** 系统异常 BUG **/
    EXCEPTION(2, "系统异常"),
    /** 未登录 **/
    NO_LOGIN(3, "未登录"),
    /** 权限不足 **/
    NO_PERMISSION(4, "权限不足"),
    /** 请求参数校验不通过 **/
    ILLEGAL_ARGUMENT(5, "请求参数校验不通过"),
    /** 不支持的请求方法 **/
    METHOD_NOT_SUPPORT(6, "不支持的请求方法"),
    /** 请求路径不存在 **/
    PATH_NOT_FOUND(7, "请求路径不存在");

    /** 状态码 **/
    private int code;
    /** 提示信息 **/
    private String message;

}
