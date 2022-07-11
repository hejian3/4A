package com.hj.fa.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
public class OauthClientAccessTokenConfig {

    @Autowired
    private DataSource dataSource;

    /**
     * 声明 ClientDetails实现
     *
     * @return ClientDetailsService
     */
    @Bean
    public JdbcClientDetailsService jdbcClientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }

    /**
     * 配置TokenStore token持久化
     */
    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
    /**
     * tokenService 配置
     */
    @Bean(name = "tokenServices")
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setClientDetailsService(jdbcClientDetailsService());
        // 允许支持refreshToken
        tokenServices.setSupportRefreshToken(true);
        // refreshToken 不重用策略
        tokenServices.setReuseRefreshToken(false);
        //设置Token存储方式
        tokenServices.setTokenStore(tokenStore());
        return tokenServices;
    }
}