package com.chenfangming.esb;

import com.chenfangming.core.Xml;
import com.chenfangming.esb.core.DefaultEsbRequestHead;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        Xml<DefaultEsbRequestHead, Xml3002XmlBody> xml = new Xml3002();
        List<String> a = new ArrayList<>();
        log.info("结束");
    }

}
