package com.hj.fa.config;

import com.hj.fa.annotation.CurrentUser;
import com.hj.fa.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Configuration
public class CurrentUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return (null != parameter.getParameterAnnotation(CurrentUser.class) && User.class == parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null && authentication instanceof OAuth2Authentication){
            OAuth2Authentication auth2Authentication = (OAuth2Authentication) authentication;
            OauthAccountUserDetails userDetails = (OauthAccountUserDetails)auth2Authentication.getPrincipal();
            return userDetails.getOauthAccount();
        }
        return null;
    }
}
