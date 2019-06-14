package com.chenfangming.common.config.exception;

import com.chenfangming.common.domain.ResponseStatus;
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
    private Integer code;

    private BizException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BizException(ResponseStatus responseStatus, Throwable cause) {
        this(responseStatus.getCode(), responseStatus.getMessage(), cause);
    }

    public BizException(ResponseStatus responseStatus, String message) {
        this(responseStatus.getCode(), message, null);
    }

    public BizException(ResponseStatus responseStatus) {
        this(responseStatus.getCode(), responseStatus.getMessage(), null);
    }

}
