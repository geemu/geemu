package com.chenfangming.manage.util.test;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

//你也可以继承或实现你的业务类
@Configuration
public class MyInterceptor implements MethodInterceptor {

//    @Override
//    public Object invoke(MethodInvocation invocation) throws Throwable {
//        //获取目标类
//        Class<?> targetClass = (invocation.getThis() != null ? AopUtils.getTargetClass(invocation.getThis()) : null);
//        //获取指定方法
//        Method specificMethod = ClassUtils.getMostSpecificMethod(invocation.getMethod(), targetClass);
//        //获取真正执行的方法,可能存在桥接方法
//        final Method userDeclaredMethod = BridgeMethodResolver.findBridgedMethod(specificMethod);
//
//        //获取方法上注解
//        Async async = AnnotatedElementUtils.findMergedAnnotation(userDeclaredMethod, Async.class);
//        if (async == null) {
//            async = AnnotatedElementUtils.findMergedAnnotation(userDeclaredMethod.getDeclaringClass(), Async.class);
//        }
//
//        //获取返回类型
//        Class<?> returnType = invocation.getMethod().getReturnType();
//        //返回类型判断
//        if (SecurityProperties.User.class.isAssignableFrom(returnType)) {
//
//            return null;
//        }
//
//        //执行具体业务逻辑
//
//        return invocation.proceed();

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        HfiTrace annotation = getAnnotation(method);
        if (annotation == null) {
            return invocation.proceed();
        }
        // 为什么调用http://127.0.0.1:8089/jpademo/perform时有两次输出呢？
        // 因为在Audience里面用的是@Around，会拦截到两次
        System.out.println("method " + invocation.getMethod() + " is called on " + invocation.getThis() + " with args" +
            " " + invocation.getArguments());
        Object proceed = invocation.proceed();
        System.out.println("method " + invocation.getMethod() + " returns " + proceed);
        return proceed;
    }

    private HfiTrace getAnnotation(Method method) {
        // 如果有多个annotation 似乎就不好用了 如放在controller上 由于已经有了@RequestMapping注解了 所以...
        if (method.isAnnotationPresent(HfiTrace.class)) {
            return method.getAnnotation(HfiTrace.class);
        }
        return null;
    }

}

