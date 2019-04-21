package com.chenfangming.gateway;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Gateway程序入口
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-11-07 22:33
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

    /**
     * 主函数
     * @param args 运行参数
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GatewayApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
