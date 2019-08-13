package com.chenfangming.manage.config.exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class ResponseEntity<T> {

    /** JACKSON **/
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        OBJECT_MAPPER.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    }

    /** 返回状态码 **/
    private String code;
    /** 返回提示信息 **/
    private String msg;
    /** 返回数据 **/
    private T data;

    /**
     * 成功
     */
    public ResponseEntity() {
        this(DefaultResponseState.SUCCESS.getCode(), DefaultResponseState.SUCCESS.getMessage(), null);
    }

    /**
     * 全参构造
     * @param code 状态码
     * @param msg 提示信息
     * @param data 数据
     */
    private ResponseEntity(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功
     * @param data 成功的数据
     */
    public ResponseEntity(T data) {
        this(DefaultResponseState.SUCCESS.getCode(), DefaultResponseState.SUCCESS.getMessage(), data);
    }

    /**
     * 成功
     * @param msg 提示信息
     * @param data 成功的数据
     */
    public ResponseEntity(String msg, T data) {
        this(DefaultResponseState.SUCCESS.getCode(), msg, data);
    }

    /**
     * 自定义
     * @param state 自定义的状态
     * @param data 自定义的数据
     */
    public ResponseEntity(ResponseState state, String msg, T data) {
        this(state.getCode(), msg, data);
    }

    /**
     * 自定义
     * @param state 自定义的状态
     */
    public ResponseEntity(ResponseState state) {
        this(state.getCode(), state.getMessage(), null);
    }

    /**
     * 自定义
     * @param ex 自定义的状态码、提示信息
     */
    public ResponseEntity(BizException ex) {
        this(ex.getCode(), ex.getMessage(), null);
    }

    /**
     * 转JSON
     * @return JSON
     */
    public String toJson() {
        try {
            return OBJECT_MAPPER.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error("转JSON异常:", e);
        }
        return null;
    }

}
