package com.github.geemu.backend.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka程序入口
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-11-06 21:02
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    /**
     * 主函数
     * @param args 运行参数
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(EurekaApplication.class);
        // 关闭启动Banner
        app.setBannerMode(org.springframework.boot.Banner.Mode.OFF);
        app.run(args);
    }
}
