package com.chenfangming.manage.domain.model;

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
public class BusinessException extends RuntimeException implements Serializable {

    /** 状态码 **/
    private int code;

    private BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(ResponseStatus responseStatus, Throwable cause) {
        this(responseStatus.getCode(), responseStatus.getMessage(), cause);
    }

    public BusinessException(ResponseStatus responseStatus, String message) {
        this(responseStatus.getCode(), message, null);
    }

    public BusinessException(ResponseStatus responseStatus) {
        this(responseStatus.getCode(), responseStatus.getMessage(), null);
    }

}
