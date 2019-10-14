package com.chenfangming.esb.core;

import com.chenfangming.core.XmlHead;
import lombok.Data;

/**
 * EsbRequestHead
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-15 00:08
 */
@Data
public class EsbRequestHead implements XmlHead {

    private String ServiceCode;

}
