package com.chenfangming.task.controller;

import com.chenfangming.task.config.AppAutoConfiguration.AppProperties;
import com.chenfangming.task.entity.TestEntity;
import com.chenfangming.task.mapper.TestMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    /** TIME **/
    private static final Long TIME = 100L;
    /** redisTemplate **/
    private RedisTemplate<String, Object> redisTemplate;
    /** appProperties **/
    private AppProperties appProperties;
    /** testMapper **/
    private TestMapper testMapper;

    /**
     * 字符串
     * @return String
     */
    @ApiOperation("字符串")
    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    /**
     * 配置中心属性
     * @return String
     */
    @ApiOperation("配置中心属性")
    @GetMapping("foo")
    public String foo() {
        return appProperties.getFoo();
    }

    /**
     * String
     * @param key key
     * @param value value
     * @return String
     */
    @ApiOperation("redis")
    @GetMapping("redis")
    public String redis(String key, String value) {
        redisTemplate.opsForValue().set(key, value + "value", TIME, TimeUnit.SECONDS);
        return (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * mysql
     * @return List<TestEntity>
     */
    @ApiOperation("mysql")
    @GetMapping("mysql")
    public List<TestEntity> mysql() {
        return testMapper.selectAll();
    }
}
