package com.chenfangming.task.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-21 12:43
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Value("${foo}")
    public String foo;

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("foo")
    public String foo() {
        return foo;
    }
}
