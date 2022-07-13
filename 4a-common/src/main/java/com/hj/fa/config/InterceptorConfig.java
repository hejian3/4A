package com.hj.fa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private CurrentUserHandlerMethodArgumentResolver currentUserHandlerMethodArgumentResolver;

    //若已经存在拦截器配置，则只需增加以下方法即可。
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserHandlerMethodArgumentResolver);
    }
}
