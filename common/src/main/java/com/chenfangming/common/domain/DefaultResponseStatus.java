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
    BAD_REQUEST(400, "请求异常"),
    INTERNAL_SERVER_ERROR(500, "系统未知异常");


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
