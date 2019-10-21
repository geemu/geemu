package com.chenfangming.esb.entity.request;

import com.chenfangming.esb.style.EsbHeadStyle;
import lombok.Builder;
import lombok.Data;

/**
 * ESB Head
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-17 23:24
 */
@Data
@Builder
public class EsbDefaultRequestHead implements EsbHeadStyle {

    private String ServiceCode;

}
