package com.chenfangming.manage.config.resolve.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 当前用户
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-07-03 21:08
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentUser {

    boolean require() default true;
    
}
