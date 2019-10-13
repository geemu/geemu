package com.chenfangming.manage.config.filter;//package com.chenfangming.manage.config.filter;
//
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
// * 权限拦截过滤器
// * @author 陈方明  cfmmail@sina.com
// * @since 2019-07-07 16:34
// */
//@Order(Integer.MIN_VALUE + 1)
//@Component
//@WebFilter(filterName = "authFilter", urlPatterns = "/*", description = "权限拦截")
//public class AuthFilter extends OncePerRequestFilter {
//
//    /**
//     * 执行过滤
//     * @param request HttpServletRequest
//     * @param response HttpServletResponse
//     * @param chain chain
//     * @throws ServletException ServletException
//     * @throws IOException IOException
//     */
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//        if (1 == 1) {
//            throw new RuntimeException("这是异常", null);
//        }
//        chain.doFilter(request, response);
//    }
//
//}
