package com.chenfangming.manage.config.security;

import com.chenfangming.manage.domain.req.NamePwdReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义用户登录
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-12-23 13:03
 */
@Slf4j
public class AuthFilter extends UsernamePasswordAuthenticationFilter {

    /** 限制只能POST **/
    private boolean postOnly = true;

    /**
     * 认证
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return Authentication
     * @throws AuthenticationException AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !HttpMethod.POST.name().equals(request.getMethod())) {
            throw new AuthenticationServiceException("不支持的身份验证方法: " + request.getMethod());
        }
        NamePwdReq user;
        //  JSON格式认证
        try (InputStream is = request.getInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            user = objectMapper.readValue(is, NamePwdReq.class);
        } catch (IOException e) {
            log.error("以JSON格式执行认证操作时，读取认证参数异常:", e);
            user = new NamePwdReq();
        }
        user.setName(null == user.getName() ? "" : user.getName().trim());
        user.setPassword(null == user.getPassword() ? "" : user.getPassword().trim());
        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword());
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    /**
     * 限制只能POST
     * @param postOnly postOnly
     */
    @Override
    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

}
