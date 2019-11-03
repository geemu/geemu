package com.chenfangming.manage.config.interceptor;

import com.chenfangming.manage.config.exception.BaseResponse;
import com.chenfangming.manage.config.exception.BaseResponse.BaseResponseState;
import com.chenfangming.manage.domain.model.CurrentUserInfo;
import com.chenfangming.manage.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * 权限拦截器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-30 21:11
 */
@Slf4j
@Configuration
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AuthService authService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 权限拦截器
     * @param request 请求
     * @param response 响应
     * @param handler 处理器
     * @return {@code true}继续执行下一步、{@code false}不继续执行
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 请求路径不存在
        if (HttpStatus.NOT_FOUND.value() == response.getStatus()) {
            log.info("请求路径:{},不存在", request.getRequestURI());
            BaseResponse<Void> responseEntity = new BaseResponse<>(BaseResponseState.PATH_NOF_FOUND);
            response.getWriter().println(objectMapper.writeValueAsString(responseEntity));
            return Boolean.FALSE;
        }
        String token = request.getHeader(CurrentUserInfo.LOGIN_USER);
        if (StringUtils.isEmpty(token)) {
            log.info("用户未登录");
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            BaseResponse<Void> responseEntity = new BaseResponse<>(BaseResponseState.NO_LOGIN);
            response.getWriter().println(objectMapper.writeValueAsString(responseEntity));
            return Boolean.FALSE;
        }
        String key = CurrentUserInfo.LOGIN_USER + token;
        CurrentUserInfo currentUserInfo = (CurrentUserInfo) redisTemplate.opsForValue().get(key);
        // 未登录
        if (null == currentUserInfo) {
            log.error("用户未登录");
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            BaseResponse<Void> responseEntity = new BaseResponse<>(BaseResponseState.NO_LOGIN);
            response.getWriter().println(objectMapper.writeValueAsString(responseEntity));
            return Boolean.FALSE;
        }
        Collection<Long> allCanRoleList = authService.getAttributes(request.getMethod().toUpperCase(), request.getRequestURI());
        boolean can = authService.decide(currentUserInfo.getRoleIdCollection(), allCanRoleList);
        // 权限不足
        if (!can) {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            BaseResponse<Void> responseEntity = new BaseResponse<>(BaseResponseState.FORBIDDEN);
            response.getWriter().println(objectMapper.writeValueAsString(responseEntity));
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
