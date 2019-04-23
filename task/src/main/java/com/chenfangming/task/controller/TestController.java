package com.chenfangming.task.controller;

import com.chenfangming.task.config.autoconfig.AppProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 测试控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-21 12:43
 */
@Api("测试控制器")
@RestController
@RequestMapping("test")
@AllArgsConstructor
public class TestController {

    private RedisTemplate<String, Object> redisTemplate;
    AppProperties appProperties;

    @ApiOperation("字符串")
    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @ApiOperation("配置中心属性")
    @GetMapping("foo")
    public String foo() {
        return appProperties.getFoo();
    }

    @ApiOperation("redis")
    @GetMapping("redis")
    public String redis(String key, String value) {
        redisTemplate.opsForValue().set(key, value + "value", 100L, TimeUnit.SECONDS);
        return (String) redisTemplate.opsForValue().get(key);
    }
}
