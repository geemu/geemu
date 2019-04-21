package com.chenfangming.backend.cloud.config;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Config配置中心程序入口
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-11-06 21:02
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigApplication {

    /**
     * 主函数
     * @param args 运行参数
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConfigApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
