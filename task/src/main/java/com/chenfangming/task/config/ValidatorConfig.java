package com.chenfangming.task.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 校验配置
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-05-06 20:14
 */
@Slf4j
@Configuration
public class ValidatorConfig {

    /** spring.aop.proxy-target-class **/
    private static final String SPRING_AOP_PROXY_TARGET_CLASS = "spring.aop.proxy-target-class";

    /**
     * Validator配置  配置快速失败
     * @return Validator Validator
     */
    @Bean
    public Validator validator() {
        log.info("初始化:Validator");
        ValidatorFactory factory = Validation
                .byProvider(HibernateValidator.class)
                .configure()
                .failFast(Boolean.TRUE)
                .buildValidatorFactory();
        return factory.getValidator();
    }

    /**
     * Spring validator支持对方法的校验
     * @return MethodValidationPostProcessor
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(Environment environment, Validator validator) {
        log.info("初始化:MethodValidationPostProcessor");
        MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
        boolean proxyTargetClass = environment.getProperty(SPRING_AOP_PROXY_TARGET_CLASS, Boolean.class, true);
        processor.setProxyTargetClass(proxyTargetClass);
        processor.setValidator(validator);
        return processor;
    }

}
