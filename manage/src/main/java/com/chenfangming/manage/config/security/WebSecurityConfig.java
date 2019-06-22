package com.chenfangming.manage.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security配置
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-11-23 15:00
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthHandler authHandler;
    @Autowired
    private UserDetailsService userDetailService;
    @Autowired
    private AccessDecisionManager accessDecide;
    @Autowired
    private FilterInvocationSecurityMetadataSource menuMatch;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requestCache().disable()
                .headers().cacheControl().disable()
                .and().addFilterAt(authFilter(), UsernamePasswordAuthenticationFilter.class)
                //  设置匿名用户为0
                .anonymous().authorities("0")
                .and().cors().disable()
                .csrf().disable()
                .httpBasic().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .logout()
                .clearAuthentication(Boolean.TRUE)
                .logoutSuccessHandler(authHandler)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(authHandler)
                .authenticationEntryPoint(authHandler)
                // authenticated()的位置不能到最后，否则会控制不到权限
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(menuMatch);
                        o.setAccessDecisionManager(accessDecide);
                        return o;
                    }
                });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected AuthFilter authFilter() throws Exception {
        AuthFilter filter = new AuthFilter();
        filter.setPostOnly(true);
        filter.setAuthenticationSuccessHandler(authHandler);
        filter.setAuthenticationFailureHandler(authHandler);
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }

}
