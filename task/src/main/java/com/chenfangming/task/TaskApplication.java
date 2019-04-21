package com.chenfangming.task;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * User程序入口
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-11-07 21:06
 */
@EnableEurekaClient
@SpringBootApplication
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
