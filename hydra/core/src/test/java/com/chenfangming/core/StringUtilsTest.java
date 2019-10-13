package com.chenfangming.core;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 字符串工具类单元测试
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-13 21:57
 */
@Slf4j
class StringUtilsTest {

    @BeforeEach
    void setUp() {
        log.info("setUp");
    }

    @AfterEach
    void tearDown() {
        log.info("tearDown");
    }

    @Test
    void isEmpty() {
        String text = null;
        Assertions.assertTrue(StringUtils.isEmpty(text));
        text = "";
        Assertions.assertTrue(StringUtils.isEmpty(text));
        text = " ";
        Assertions.assertFalse(StringUtils.isEmpty(text));
        text = "非空";
        Assertions.assertFalse(StringUtils.isEmpty(text));
        text = "非 空";
        Assertions.assertFalse(StringUtils.isEmpty(text));
    }
}
