package com.hj.fa.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true) // Spring Security 方法权限
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Value("${hj.4a.permit_all_url}")
    private String  primitAllURL;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and().csrf().disable()
                .authorizeRequests()
                //处理跨域请求中的Preflight请求
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers(primitAllURL.split(","))
                .permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and().httpBasic();
    }
}
