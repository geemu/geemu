package com.chenfangming.task.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    public MethodValidationPostProcessor methodValidationPostProcessor(Validator validator) {
        log.info("初始化:MethodValidationPostProcessor");
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setValidator(validator);
        return postProcessor;
    }

}
