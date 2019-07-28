//package com.chenfangming.manage.config.filter;
//
//import com.chenfangming.manage.config.exception.ErrorResponseWrapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.web.util.NestedServletException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 异常处理过滤器
// * @author 陈方明  cfmmail@sina.com
// * @since 2019-07-07 17:23
// */
//@Slf4j
//@Order(Integer.MIN_VALUE)
//@Component
//@WebFilter(filterName = "errorFilter", urlPatterns = "/*", description = "权限拦截")
//public class ErrorFilter extends OncePerRequestFilter {
//
//    /**
//     * 执行异常处理
//     * @param request HttpServletRequest
//     * @param response HttpServletResponse
//     * @param chain chain
//     */
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException {
//        doFilter(request, response, chain);
//    }
//
//    private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException {
//        ErrorResponseWrapper wrapped = new ErrorResponseWrapper(response);
//        try {
//            chain.doFilter(request, wrapped);
//            if (wrapped.hasError()) {
//                System.out.println("处理异常");
//                response.setCharacterEncoding("utf-8");
//                response.setContentType("application/json;charset=utf-8");
//                response.getWriter().write("dasddada好人asdas");
//                response.flushBuffer();
//            } else if (!request.isAsyncStarted() && !response.isCommitted()) {
//                response.flushBuffer();
//            }
//        } catch (Throwable ex) {
//            Throwable exceptionToHandle = ex;
//            if (ex instanceof NestedServletException) {
//                exceptionToHandle = ((NestedServletException) ex).getRootCause();
//            }
//            System.out.println("处理异常" + ex);
//            response.getWriter().write("dasdasdas");
//            response.flushBuffer();
//        }
//    }
//
//
//}
