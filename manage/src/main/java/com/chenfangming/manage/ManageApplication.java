package com.chenfangming.manage;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Manage后台管理程序入口
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-21 16:37
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ManageApplication {

    /**
     * 主函数
     * @param args 运行参数
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ManageApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
