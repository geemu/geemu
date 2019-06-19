//package com.chenfangming.manage.config.security;
//
//import com.chenfangming.common.domain.DefaultResponseStatus;
//import com.chenfangming.common.domain.ResponseEntity;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 认证成功、失败处理器
// * @author 陈方明  cfmmail@sina.com
// * @since 2019-06-16 18:12
// */
//@Slf4j
//@Component
//public class AuthenticationHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler, AccessDeniedHandler, AuthenticationEntryPoint, LogoutSuccessHandler {
//
//    /** 构造注入 **/
//    private ObjectMapper objectMapper;
//
//    /**
//     * 认证成功后流程
//     * 返回成功
//     * @param request 请求
//     * @param response 响应
//     * @param auth 认证对象
//     */
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException {
//        log.info(">>>>>>>>>>>>>>>>>>>>用户认证成功:{}<<<<<<<<<<<<<<<<<<<<", auth);
//        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
//        response.getWriter().print(objectMapper.writeValueAsString(new ResponseEntity<>()));
//        response.getWriter().flush();
//    }
//
//    /**
//     * 认证失败后流程
//     * 返回失败
//     * @param request 请求
//     * @param response 响应
//     * @param e 异常
//     */
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
//        log.info(">>>>>>>>>>>>>>>>>>>>用户认证失败:<<<<<<<<<<<<<<<<<<<<", e);
//        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
//        ResponseEntity<Void> responseEntity;
//        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
//            //  用户名或密码错误
//            responseEntity = new ResponseEntity<>(DefaultResponseStatus.FAIL, "用户名或密码错误");
//        } else if (e instanceof DisabledException) {
//            //  账户被禁用
//            responseEntity = new ResponseEntity<>(DefaultResponseStatus.FAIL, "账户被禁用");
//        } else {
//            //  其它认证异常
//            responseEntity = new ResponseEntity<>(DefaultResponseStatus.FAIL, e.getMessage());
//        }
//        response.getWriter().print(objectMapper.writeValueAsString(responseEntity));
//        response.getWriter().flush();
//    }
//
//    /**
//     * 认证用户访问无权限资源处理流程
//     * 返回未认证
//     * @param request 请求
//     * @param response 响应
//     * @param e 异常
//     */
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException {
//        log.info(">>>>>>>>>>>>>>>>>>>>认证用户访问无权限资源:<<<<<<<<<<<<<<<<<<<<", e);
//        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
//        response.getWriter().print(
//                objectMapper.writeValueAsString(new ResponseEntity<>(DefaultResponseStatus.NO_AUTHORIZE)
//                ));
//        response.getWriter().flush();
//    }
//
//    /**
//     * 匿名用户访问无权限资源处理流程
//     * 返回未登录
//     * @param request 请求
//     * @param response 响应
//     * @param e 异常
//     */
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
//        log.info(">>>>>>>>>>>>>>>>>>>>匿名用户访问无权限资源:<<<<<<<<<<<<<<<<<<<<", e);
//        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
//        response.getWriter().print(
//                objectMapper.writeValueAsString(new ResponseEntity<>(DefaultResponseStatus.NO_AUTHENTICATION)
//                ));
//        response.getWriter().flush();
//    }
//
//    /**
//     * 注销成功处理流程
//     * @param request 请求
//     * @param response 响应
//     * @param auth 认证实体
//     */
//    @Override
//    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException {
//        log.info(">>>>>>>>>>>>>>>>>>>>注销成功处理流程:{}<<<<<<<<<<<<<<<<<<<<", auth);
//        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
//        response.getWriter().print(objectMapper.writeValueAsString(
//                new ResponseEntity<>()
//        ));
//        response.getWriter().flush();
//    }
//
//}
