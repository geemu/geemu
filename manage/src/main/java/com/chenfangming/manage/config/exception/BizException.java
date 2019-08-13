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
    private static final long serialVersionUID = -1;

    /** 状态码 **/
    private String code;

    public BizException(ResponseState status, Throwable cause) {
        this(status.getCode(), status.getMessage(), cause);
    }

    private BizException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BizException(ResponseState code, String message) {
        this(code.getCode(), message, null);
    }

    public BizException(ResponseState status) {
        this(status.getCode(), status.getMessage(), null);
    }

}
