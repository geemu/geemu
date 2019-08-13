package com.chenfangming.manage.config.interceptor;

import com.chenfangming.manage.constants.SessionKey;
import com.chenfangming.manage.domain.model.CurrentUserInfo;
import com.chenfangming.manage.persistence.entity.RoleEntity;
import com.chenfangming.manage.service.MenuService;
import com.chenfangming.manage.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 权限拦截器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-30 21:11
 */
@Slf4j
@Configuration
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

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
        CurrentUserInfo currentUserInfo = (CurrentUserInfo) request.getSession().getAttribute(SessionKey.CURRENT_USER.name());
        if (null == currentUserInfo) {
            log.error("用户未登录");
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().println("用户未登录");
            return Boolean.FALSE;
        }
        List<RoleEntity> allCanRoleList = roleService.selectByRequest(request.getMethod().toUpperCase(), request.getRequestURI());
        boolean can = menuService.canAccess(currentUserInfo.getRoleIdList(), allCanRoleList);
        if (!can) {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().println("没有权限");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
