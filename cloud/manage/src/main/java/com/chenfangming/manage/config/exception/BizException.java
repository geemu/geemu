package com.chenfangming.manage.config.exception;

import com.chenfangming.manage.config.exception.BaseResponse.BaseResponseState;
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
    private static final long serialVersionUID = -1L;

    /** 返回状态码 **/
    private Integer code;
    /** 返回提示信息 **/
    private String message;

    /**
     * 构造
     * @param code 返回状态码
     * @param message 返回提示信息
     */
    private BizException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 构造
     * @param code 返回状态码
     * @param message 返回提示信息
     */
    public BizException(BaseResponseState code, String message) {
        this.code = code.getCode();
        this.message = message;
    }

    /**
     * 构造
     * @param state 返回状态码
     */
    public BizException(BaseResponseState state) {
        this.code = state.getCode();
        this.message = state.getMessage();
    }

}
