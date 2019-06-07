package com.chenfangming.manage.config.auto;

import com.chenfangming.manage.config.auto.AppAutoConfiguration.AppProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 应用自动配置类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-23 22:07
 */
@Configuration
@EnableConfigurationProperties(AppProperties.class)
public class AppAutoConfiguration {

    @Data
    @ConfigurationProperties(prefix = "app")
    public class AppProperties {
        /** QQ **/
        private QqProperties qq;
    }

    @Data
    public static class QqProperties {
        /** appId **/
        private String appId;
        /** appKey **/
        private String appKey;
        /** 回调地址 **/
        private String callBackUrl;
        /** QQ互联认证服务器地址 **/
        private String oauthServerUrl;
    }

}
