package com.hj.fa.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private OauthAccountUserDetailsService oauthAccountUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${hj.4a.permit_all_url}")
    private String primitAllURL;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(oauthAccountUserDetailsService).passwordEncoder(passwordEncoder);
        auth.eraseCredentials(true);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
