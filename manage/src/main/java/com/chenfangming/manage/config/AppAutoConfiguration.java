package com.chenfangming.manage.config;

import com.chenfangming.manage.config.property.AppProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 应用自动配置类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-23 22:07
 */
@Configuration
@EnableConfigurationProperties(AppProperty.class)
public class AppAutoConfiguration {

}
