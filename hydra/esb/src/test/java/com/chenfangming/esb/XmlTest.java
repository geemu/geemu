package com.chenfangming.esb;

import com.chenfangming.esb.core.EsbRequest;
import com.chenfangming.esb.entity.request.Esb3002;
import com.chenfangming.esb.entity.request.EsbDefaultRequestHead;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * EsbTest
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-14 23:23
 */
@Slf4j
public class XmlTest {

    @Test
    void getHead() {
        log.info("开始");
        EsbRequest<Esb3002> esb = EsbRequest.<Esb3002>builder()
                .Head(EsbDefaultRequestHead
                        .builder()
                        .build())
                .Body(Esb3002
                        .builder()
                        .build())
                .build();
        System.out.println(esb.getHead().getClass().getName());
        log.info("结束");
    }

}
