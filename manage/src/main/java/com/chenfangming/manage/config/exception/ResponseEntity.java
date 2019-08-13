package com.chenfangming.manage.config.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 基础封装返回体
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-10-27 10:18
 */
@Getter
@ToString
@EqualsAndHashCode
public class ResponseEntity<T> {

    /** 返回状态 **/
    private Integer code;
    /** 返回提示信息 **/
    private String msg;
    /** 返回数据 **/
    private T data;

    /**
     * 成功
     * @param msg 成功的提示
     * @param data 成功的数据
     */
    public ResponseEntity(String msg, T data) {
        this(DefaultResponseStatus.SUCCESS.getCode(), msg, data);
    }

    /**
     * 成功
     */
    public ResponseEntity() {
        this(DefaultResponseStatus.SUCCESS.getCode(), DefaultResponseStatus.SUCCESS.getMessage(), null);
    }

    /**
     * 成功
     * @param data 成功的数据
     */
    public ResponseEntity(T data) {
        this(DefaultResponseStatus.SUCCESS.getCode(), DefaultResponseStatus.SUCCESS.getMessage(), data);
    }

    private ResponseEntity(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 自定义
     * @param code 自定义的状态码
     * @param msg 自定义的提示信息
     * @param data 自定义的数据
     */
    public ResponseEntity(ResponseStatus code, String msg, T data) {
        this(code.getCode(), msg, data);
    }

    /**
     * 自定义
     * @param code 自定义的状态码
     * @param msg 自定义的提示信息
     */
    public ResponseEntity(ResponseStatus code, String msg) {
        this(code.getCode(), msg, null);
    }

    /**
     * 自定义
     * @param status 自定义的状态码、提示信息
     * @param data 自定义的数据
     */
    public ResponseEntity(ResponseStatus status, T data) {
        this(status.getCode(), status.getMessage(), data);
    }

    /**
     * 自定义
     * @param status 自定义的状态码、提示信息
     */
    public ResponseEntity(ResponseStatus status) {
        this(status.getCode(), status.getMessage(), null);
    }

    /**
     * 自定义
     * @param ex 自定义的状态码、提示信息
     */
    public ResponseEntity(BizException ex) {
        this(ex.getCode(), ex.getMessage(), null);
    }

}
