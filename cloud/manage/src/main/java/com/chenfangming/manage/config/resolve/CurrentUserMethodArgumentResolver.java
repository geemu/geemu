package com.chenfangming.manage.config.resolve;

import com.chenfangming.manage.config.exception.BaseResponse.BaseResponseState;
import com.chenfangming.manage.config.exception.BizException;
import com.chenfangming.manage.config.resolve.annotation.CurrentUser;
import com.chenfangming.manage.domain.model.CurrentUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


/**
 * 注入当前用户
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-07-03 21:01
 */
@Slf4j
@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 当前解析器是否支持当前参数的解析
     * @param parameter 要检查的方法参数
     * @return {@code true} 如果此解析器支持提供的参数|{@code false} 其它情况
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(CurrentUserInfo.class) && parameter.hasParameterAnnotation(CurrentUser.class);
    }

    /**
     * 解析参数
     * @param parameter parameter
     * @param mavContainer mavContainer
     * @param webRequest webRequest
     * @param binderFactory binderFactory
     * @return Object
     * @throws Exception Exception
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String token = (String) webRequest.getAttribute("Authorization", RequestAttributes.SCOPE_SESSION);
        CurrentUser currentUser = parameter.getParameter().getAnnotation(CurrentUser.class);
        if (null == token && currentUser.require()) {
            throw new BizException(BaseResponseState.NO_LOGIN);
        } else if (null == token) {
            return null;
        }
        CurrentUserInfo currentUserInfo = (CurrentUserInfo) redisTemplate.opsForHash().get(CurrentUserInfo.LOGIN_USER + token, CurrentUserInfo.CURRENT_USER);
        if (null == currentUserInfo) {
            throw new BizException(BaseResponseState.NO_LOGIN);
        }
        return currentUserInfo;
    }

}
