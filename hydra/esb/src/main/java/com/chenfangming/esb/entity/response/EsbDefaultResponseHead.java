package com.chenfangming.esb.entity.response;

import com.chenfangming.esb.style.EsbHeadStyle;
import lombok.Data;

/**
 * ESB Head
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-17 23:25
 */
@Data
public class EsbDefaultResponseHead implements EsbHeadStyle {

    private String ServiceCode;
    private String ErrorCode;
    private String ErrorMessage;

}
