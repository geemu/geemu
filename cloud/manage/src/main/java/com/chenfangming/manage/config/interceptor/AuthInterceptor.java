package com.chenfangming.manage.config.interceptor;

import com.chenfangming.manage.config.exception.BaseResponse;
import com.chenfangming.manage.config.exception.BaseResponse.BaseResponseState;
import com.chenfangming.manage.constants.SessionKey;
import com.chenfangming.manage.domain.model.CurrentUserInfo;
import com.chenfangming.manage.persistence.entity.RoleEntity;
import com.chenfangming.manage.service.MenuService;
import com.chenfangming.manage.service.RoleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private ObjectMapper objectMapper;

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
            log.error("请求路径:{},不存在", request.getRequestURI());
            BaseResponse<Void> responseEntity = new BaseResponse<>(BaseResponseState.PATH_NOF_FOUND);
            response.getWriter().println(responseEntity.toJson());
            return Boolean.FALSE;
        }
        CurrentUserInfo currentUserInfo = (CurrentUserInfo) request.getSession().getAttribute(SessionKey.CURRENT_USER.name());
        // 未登录
        if (null == currentUserInfo) {
            log.error("用户未登录");
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            BaseResponse<Void> responseEntity = new BaseResponse<>(BaseResponseState.NO_LOGIN);
            response.getWriter().println(responseEntity.toJson());
            return Boolean.FALSE;
        }
        List<RoleEntity> allCanRoleList = roleService.selectByRequest(request.getMethod().toUpperCase(), request.getRequestURI());
        boolean can = menuService.canAccess(currentUserInfo.getRoleIdList(), allCanRoleList);
        // 权限不足
        if (!can) {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            BaseResponse<Void> responseEntity = new BaseResponse<>(BaseResponseState.FORBIDDEN);
            response.getWriter().println(responseEntity.toJson());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
