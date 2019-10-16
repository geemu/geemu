package com.chenfangming.esb.core.entity;

import com.chenfangming.esb.core.sign.EsbHeadStyle;
import lombok.Data;

/**
 * EsbRequestHead
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-15 00:08
 */
@Data
public class EsbResponseHead implements EsbHeadStyle {

    private String ServiceCode;

}
