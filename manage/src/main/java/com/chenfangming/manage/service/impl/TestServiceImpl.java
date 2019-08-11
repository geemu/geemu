package com.chenfangming.manage.service.impl;

import com.chenfangming.manage.service.TestService;
import com.chenfangming.manage.test.HfiTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * com.chenfangming.manage.service.impl
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-07-30 21:25
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @HfiTrace
    @Override
    public String cache1() {
        log.info("cache1失效");
        return "这是cache1";
    }

    @Cacheable(cacheNames = {"a"}, key = "'cache2'")
    @Override
    public String cache2() {
        log.info("cache2失效");
        return "这是cache2";
    }

    @Override
    public String cache3() {
        return cache();
    }

    @Cacheable(cacheNames = {"a"}, key = "'cache3'")
    public String cache() {
        log.info("cache3失效");
        return "这是cache3";
    }

}
