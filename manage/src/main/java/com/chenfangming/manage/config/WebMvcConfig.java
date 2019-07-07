package com.chenfangming.manage.config;

import com.chenfangming.manage.config.resolve.CurrentUserMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * com.chenfangming.manage.config
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-10 21:30
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private CurrentUserMethodArgumentResolver resolver;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Swagger
        registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/swagger-resources/**")
            .addResourceLocations("classpath:/META-INF/resources/swagger-resources/");
        registry.addResourceHandler("/swagger/**")
            .addResourceLocations("classpath:/META-INF/resources/swagger*");
        registry.addResourceHandler("/v2/api-docs/**")
            .addResourceLocations("classpath:/META-INF/resources/v2/api-docs/");
        // 自定义资源
        registry.addResourceHandler("index.html")
            .addResourceLocations("classpath:/public/");
        registry.addResourceHandler("js/**")
            .addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("img/**")
            .addResourceLocations("classpath:/static/img/");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(resolver);
    }

}
