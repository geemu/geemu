package com.chenfangming.common.cache.interceptor;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * com.chenfangming.common.cache.interceptor
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-07-28 12:22
 */
public class CacheInterceptor implements MethodInterceptor, Serializable {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }

}
