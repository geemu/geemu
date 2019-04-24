package com.chenfangming.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * User程序入口
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-11-07 21:06
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.chenfangming.task.mapper")
public class TaskApplication {

    /**
     * 主函数
     * @param args 运行参数
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TaskApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
