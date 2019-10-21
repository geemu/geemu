package com.chenfangming.esb.core;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ESB 默认响应
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-18 21:10
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class EsbResponse<Body extends EsbBodyStyle> extends AbstractEsb<EsbDefaultResponseHead, Body> implements Esb<EsbDefaultResponseHead, Body> {

    /** Head **/
    private EsbDefaultResponseHead Head;
    /** Body **/
    private Body Body;

}
