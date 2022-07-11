package com.hj.fa.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String [] args){
        System.out.println(new BCryptPasswordEncoder().encode("leador@12345"));
        System.out.println(new BCryptPasswordEncoder().encode("12345"));
    }
}
