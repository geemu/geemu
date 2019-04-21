package com.chenfangming.task.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-21 12:43
 */
@Api("测试控制器")
@RestController
@RequestMapping("test")
public class TestController {

    @Value("${foo}")
    public String foo;

    @ApiOperation("hello")
    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @ApiOperation("foo")
    @GetMapping("foo")
    public String foo() {
        return foo;
    }
}
