package com.chenfangming.common.domain;

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
    /** 加密异常 **/
    ENCRYPT_EXCEPTION(3, "加密异常"),
    /** 解密异常 **/
    DECRYPT_EXCEPTION(4, "解密异常"),
    /** 插数据入数据库异常 **/
    INSERT_EXCEPTION(5, "新增数据库数据异常"),
    /** 删除数据库数据异常 **/
    DELETE_EXCEPTION(6, "删除数据库数据异常"),
    /** 修改数据库数据异常 **/
    UPDATE_EXCEPTION(7, "修改数据库数据异常"),
    /** 查询数据库数据异常 **/
    SELECT_EXCEPTION(8, "查询数据库数据异常"),
    /** 远程调用异常 **/
    REMOTE_INVOCATION(9, "远程调用异常"),
    /** 转换异常 **/
    CONVERT_EXCEPTION(10, "数据转换异常"),
    /** 格式化异常 **/
    FORMAT_EXCEPTION(11, "格式化异常"),
    /** 未登录 **/
    NO_AUTHENTICATION(12, "未认证"),
    /** 权限不足 **/
    NO_AUTHORIZE(13, "未授权"),
    /** 认证已过期 **/
    AUTHENTICATION_EXPIRED(14, "认证已过期"),
    /** 图形、短信、语音验证码已过期 **/
    CAPTCHA_EXPIRED(15, "验证码已过期"),
    /** 请求参数校验不通过 **/
    ILLEGAL_ARGUMENT(16, "请求参数校验不通过"),
    /** 不支持的请求方法 **/
    METHOD_NOT_SUPPORT(17, "不支持的请求方法"),
    /** 请求路径不存在 **/
    PATH_NOT_FOUND(18, "请求路径不存在");

    /** 状态码 **/
    private Integer code;
    /** 提示信息 **/
    private String message;

}
