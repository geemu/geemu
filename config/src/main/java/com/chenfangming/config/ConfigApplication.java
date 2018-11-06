package com.chenfangming.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Config程序入口
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-11-06 21:02
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {
    /**
     * 主函数
     * @param args 运行参数
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConfigApplication.class);
        // 关闭启动Banner
        app.setBannerMode(org.springframework.boot.Banner.Mode.OFF);
        app.run(args);
    }
}
