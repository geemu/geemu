package com.chenfangming.esb.entity.request;

import com.chenfangming.esb.style.EsbBodyStyle;
import lombok.Builder;
import lombok.Data;

/**
 * Esb3002
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-15 00:32
 */
@Data
@Builder
public class Esb3002 implements EsbBodyStyle {

    private String Data;

}
