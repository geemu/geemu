package com.chenfangming.manage.controller;

import com.chenfangming.common.domain.ResponseEntity;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 23:27
 */
@Slf4j
@Validated
@RestController
@AllArgsConstructor
@Api(tags = "测试控制器")
@RequestMapping("test")
public class TestController {

    @GetMapping
    public ResponseEntity<String> data(String data) {
        return new ResponseEntity<>(data);
    }

}
