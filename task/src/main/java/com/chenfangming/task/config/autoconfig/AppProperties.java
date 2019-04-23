package com.chenfangming.task.config.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 应用自动配置属性
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-23 22:23
 */
@Data
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    /** foo **/
    private String foo;
}
