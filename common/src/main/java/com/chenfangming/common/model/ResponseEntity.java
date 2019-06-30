package com.chenfangming.common.model;

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
    private int code;
    /** 返回提示信息 **/
    private String message;
    /** 返回数据 **/
    private T data;

    private ResponseEntity(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    /**
     * 成功
     * @param message 成功的提示
     * @param data 成功的数据
     */
    public ResponseEntity(String message, T data) {
        this(DefaultResponseStatus.SUCCESS.getCode(), message, data);
    }

    /**
     * 自定义
     * @param code 自定义的状态码
     * @param message 自定义的提示信息
     * @param data 自定义的数据
     */
    public ResponseEntity(ResponseStatus code, String message, T data) {
        this(code.getCode(), message, data);
    }

    /**
     * 自定义
     * @param code 自定义的状态码
     * @param message 自定义的提示信息
     */
    public ResponseEntity(ResponseStatus code, String message) {
        this(code.getCode(), message, null);
    }

    /**
     * 自定义
     * @param responseStatus 自定义的状态码、提示信息
     * @param data 自定义的数据
     */
    public ResponseEntity(ResponseStatus responseStatus, T data) {
        this(responseStatus.getCode(), responseStatus.getMessage(), data);
    }

    /**
     * 自定义
     * @param responseStatus 自定义的状态码、提示信息
     */
    public ResponseEntity(ResponseStatus responseStatus) {
        this(responseStatus.getCode(), responseStatus.getMessage(), null);
    }

    /**
     * 自定义
     * @param ex 自定义的状态码、提示信息
     */
    public ResponseEntity(BizException ex) {
        this(ex.getCode(), ex.getMessage(), null);
    }

}
