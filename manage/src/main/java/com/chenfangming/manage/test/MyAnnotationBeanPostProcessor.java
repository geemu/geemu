//package com.chenfangming.manage.test;
//
//import org.aopalliance.intercept.MethodInterceptor;
//import org.springframework.aop.framework.AbstractAdvisingBeanPostProcessor;
//import org.springframework.aop.support.DefaultPointcutAdvisor;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.BeanFactoryAware;
//import org.springframework.scheduling.annotation.AsyncAnnotationAdvisor;
//
//import java.lang.annotation.Annotation;
//
///**
// * com.chenfangming.manage.test
// * @author 陈方明  cfmmail@sina.com
// * @since 2019-07-30 23:08
// */
//
//public class MyAnnotationBeanPostProcessor extends AbstractAdvisingBeanPostProcessor implements BeanFactoryAware {
//
//    private MethodInterceptor interceptor;
//    private Class<? extends Annotation> annotation;
//
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        setBeforeExistingAdvisors(true);
//        AsyncAnnotationAdvisor advisor = new AsyncAnnotationAdvisor(this.annotation, this.interceptor);
//        advisor.setBeanFactory(beanFactory);
//        this.advisor = advisor;
//    }
//
//    public MethodInterceptor getInterceptor() {
//        return interceptor;
//    }
//
//    public void setInterceptor(MethodInterceptor interceptor) {
//        this.interceptor = interceptor;
//    }
//
//    public Class<? extends Annotation> getAnnotation() {
//        return annotation;
//    }
//
//    public void setAnnotation(Class<? extends Annotation> annotation) {
//        this.annotation = annotation;
//    }
//}
