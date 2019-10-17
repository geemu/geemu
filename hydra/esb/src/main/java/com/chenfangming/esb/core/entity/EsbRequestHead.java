package com.chenfangming.esb.core.entity;

import com.chenfangming.esb.core.impl.sign.EsbHead;
import lombok.Data;

/**
 * EsbRequestHead
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-15 00:08
 */
@Data
public class EsbRequestHead implements EsbHead {

    private String ServiceCode;

}
