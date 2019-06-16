package com.chenfangming.manage.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 应用配置
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-07 21:10
 */
@Data
@ConfigurationProperties(prefix = "app")
public class AppProperty {

    /** QQ **/
    private QqProperty qq;

}
