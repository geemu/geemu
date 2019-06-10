package com.chenfangming.manage.controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.chenfangming.manage.controller
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-10 21:25
 */
@Slf4j
@RestController
@AllArgsConstructor
@Api(tags = "测试控制器")
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String test() {
        int i = 1 / 0;
        return "dasa";
    }
}
