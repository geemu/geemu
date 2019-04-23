package com.chenfangming.task.config.redis;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * RedisTemplate配置
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-23 21:26
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class RedisTemplateConfig {

    private RedisConnectionFactory connectionFactory;
    private StringRedisSerializer stringSerializer;
    private Jackson2JsonRedisSerializer<Object> jackson2JsonSerializer;


    /**
     * 自定义序列化模板
     * 序列化时带上参数类型
     * @return RedisTemplate
     */
    @Bean("redisTemplate")
    public RedisTemplate<String, Object> redisTemplate() {
        log.info("初始化:RedisTemplate");
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setDefaultSerializer(stringSerializer);
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(jackson2JsonSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
