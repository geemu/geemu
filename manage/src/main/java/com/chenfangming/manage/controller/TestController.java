package com.chenfangming.manage.controller;


import com.chenfangming.manage.config.exception.ResponseEntity;
import com.chenfangming.manage.config.resolve.CurrentUserInfo;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试控制器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 23:27
 */
@Slf4j
@Validated
@RestController
@AllArgsConstructor
@Api(tags = "测试控制器")
@RequestMapping("test")
public class TestController {

    private static List<String> urls = new ArrayList<>();
    @Autowired
    private DispatcherServlet dispatcherServlet;
    @Autowired
    private WebApplicationContext applicationContext;

    @Cacheable(cacheNames = "data", key = "'dada'")
    @GetMapping
    public ResponseEntity<List<String>> data(String data) {
        List<HandlerMapping> list = dispatcherServlet.getHandlerMappings();
        System.out.println(list);
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        // 获取url与类和方法的对应信息
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        for (RequestMappingInfo info : map.keySet()) {
            // 获取url的Set集合，一个方法可能对应多个url
            Set<String> patterns = info.getPatternsCondition().getPatterns();
            for (String url : patterns) {
                //把结果存入静态变量中程序运行一次次方法之后就不用再次请求次方法
                urls.add(url);
            }
        }
        System.out.println(urls);
        return new ResponseEntity<>(urls);
    }

    @PostMapping
    public void get(@Valid CurrentUserInfo currentUser) {
        System.out.println(currentUser);
    }

}
