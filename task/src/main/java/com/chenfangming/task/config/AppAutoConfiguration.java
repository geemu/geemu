package com.chenfangming.task.config;

import com.chenfangming.task.config.AppAutoConfiguration.AppProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
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

    @Data
    @ConfigurationProperties(prefix = "app")
    public static class AppProperties {
        /** foo **/
        private String foo;
    }

}
