package com.github.geemu.backend.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Gateway程序入口
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-11-07 22:33
 */
@EnableEurekaClient
@SpringBootApplication
public class GatewayApplication {
    /**
     * 主函数
     * @param args 运行参数
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GatewayApplication.class);
        // 关闭启动Banner
        app.setBannerMode(org.springframework.boot.Banner.Mode.OFF);
        app.run(args);
    }

}
