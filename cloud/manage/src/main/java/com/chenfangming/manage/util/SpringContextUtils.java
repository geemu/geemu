package com.chenfangming.manage.util;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring工具类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-07 17:35
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 根据beanName、type获取Bean
     * @param beanName beanName
     * @param requiredType 类型
     * @param <T> 类类型
     * @return Bean实例
     */
    public static <T> T getBean(String beanName, Class<T> requiredType) {
        return applicationContext.getBean(beanName, requiredType);
    }

    /**
     * 是否包含某个名称的bean
     * @param beanName beanName
     * @return {@code true}包含、{@code false}不包含
     */
    public static boolean containsBean(String beanName) {
        return applicationContext.containsBean(beanName);
    }

    /**
     * 是否是单例
     * @param beanName beanName
     * @return {@code true}单例、{@code false}不是单例
     */
    public static boolean isSingleton(String beanName) {
        return applicationContext.isSingleton(beanName);
    }

    /**
     * 获取beanName的bean类型
     * @param beanName beanName
     * @return 类型
     */
    public static Class<? extends Object> getType(String beanName) {
        return applicationContext.getType(beanName);
    }

    /**
     * 获取目标类型的实例
     * @param beanName beanName
     * @param targetClass targetClass
     * @param <T> 类类型
     * @return T
     * @throws Exception Exception
     */
    @SuppressWarnings({"unchecked"})
    public static <T> T getTargetObject(String beanName, Class<T> targetClass) throws Exception {
        Object proxy = getBean(beanName);
        if (AopUtils.isJdkDynamicProxy(proxy)) {
            return (T) ((Advised) proxy).getTargetSource().getTarget();
        } else {
            return (T) proxy;
        }
    }

    /**
     * 根据beanName获取Bean
     * @param beanName beanName
     * @return Bean实例
     */
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

}
