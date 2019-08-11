package com.chenfangming.manage.test;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * com.chenfangming.manage.test
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-07-30 22:58
 */

@Configuration
public class InterceptorAnnotationConfig {

    @Autowired
    private MyInterceptor myInterceptor;

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor3() {
//        MyInterceptor interceptor = new MyInterceptor();
        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(HfiTrace.class, true);
//        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
//        pointcut.setPatterns("com.hfi.*");
        // 配置增强类advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(myInterceptor);
        return advisor;
    }

}
