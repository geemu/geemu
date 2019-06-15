//package com.chenfangming.manage.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 异常处理
// * @author 陈方明  cfmmail@sina.com
// * @since 2019-06-15 16:13
// */
//@Slf4j
//@Component
//@WebFilter(urlPatterns = "/**", filterName = "errorFilter")
//@Order(Ordered.HIGHEST_PRECEDENCE + 1)
//public class MyErrorFilter extends OncePerRequestFilter {
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//        int i = 1 / 0;
//        chain.doFilter(request, response);
//    }
//}
