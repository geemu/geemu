package com.chenfangming.task.config.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 应用自动配置类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-23 22:07
 */
@Data
@Configuration
@EnableConfigurationProperties(AppProperties.class)
public class AppAutoConfiguration {


}
