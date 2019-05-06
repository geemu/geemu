package com.chenfangming.task.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class RedisConfig {

    /** 连接 **/
    private RedisConnectionFactory connectionFactory;

    /**
     * StringRedisSerializer序列化
     * @return StringRedisSerializer
     */
    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        log.info("初始化:StringRedisSerializer");
        return new StringRedisSerializer();
    }

    /**
     * Jackson2JsonRedisSerializer序列化
     * 序列化时带上参数类型
     * @return Jackson2JsonRedisSerializer
     */
    @Bean
    public Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer() {
        log.info("初始化:Jackson2JsonRedisSerializer");
        Jackson2JsonRedisSerializer<Object> response = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        response.setObjectMapper(objectMapper);
        return response;
    }

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
        redisTemplate.setDefaultSerializer(stringRedisSerializer());
        redisTemplate.setKeySerializer(stringRedisSerializer());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(stringRedisSerializer());
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
