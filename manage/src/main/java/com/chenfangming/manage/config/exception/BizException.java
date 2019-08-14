package com.chenfangming.manage.config.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 业务异常
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-10-27 10:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = 1L;

    /** 状态码 **/
    private String code;
    /** 异常返回的数据 **/
    private Object data;

    public BizException(ResponseState code, String message, Object data) {
        this(code.getCode(), message, data);
    }

    private BizException(String code, String message, Object data) {
        super(message);
        this.code = code;
    }

    public BizException(ResponseState state, Object data) {
        this(state.getCode(), state.getMessage(), data);
    }

    public BizException(ResponseState code, String message) {
        this(code.getCode(), message, null);
    }

}
