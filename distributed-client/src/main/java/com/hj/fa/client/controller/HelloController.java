package com.hj.fa.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "order id : " + id;
    }

    @GetMapping("/test")
    public String hello() {
        return " hello test ";
    }

    @GetMapping("/principle")
    public OAuth2Authentication getPrinciple(OAuth2Authentication oAuth2Authentication, Principal principal, Authentication authentication) {
        log.info(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
        log.info(oAuth2Authentication.toString());
        log.info("principal.toString() " + principal.toString());
        log.info("principal.getName() " + principal.getName());
        log.info("authentication: " + authentication.getAuthorities().toString());
        return oAuth2Authentication;
    }
}
