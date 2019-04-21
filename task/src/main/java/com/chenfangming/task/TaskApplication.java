package com.chenfangming.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User程序入口
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-11-07 21:06
 */
@RestController
@EnableEurekaClient
@SpringBootApplication
public class TaskApplication {
    @Value("${foo}")
    public String foo;

    /**
     * 主函数
     * @param args 运行参数
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TaskApplication.class);
        // 关闭启动Banner
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }


    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("foo")
    public String foo() {
        return foo;
    }
}
