package com.hj.fa.config;


import com.hj.fa.model.Privileges;
import com.hj.fa.model.User;
import com.hj.fa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.BadClientCredentialsException;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OauthAccountUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    private final BasicAuthenticationConverter authenticationConverter = new BasicAuthenticationConverter();

    @Autowired
    private JdbcClientDetailsService jdbcClientDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String clientId;
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof org.springframework.security.core.userdetails.User) {
                org.springframework.security.core.userdetails.User clientUser = (org.springframework.security.core.userdetails.User) principal;
                clientId = clientUser.getUsername();
            } else if (principal instanceof OauthAccountUserDetails) {
                return (OauthAccountUserDetails) principal;
            } else {
                throw new UnsupportedOperationException();
            }
        } else {
            clientId = getClientIdByRequest();
        }
        // 获取用户
        User account = userService.getUserByUserName(clientId, username);
        // 用户不存在
        if (account == null || account.getIsDelete()) {
            throw new UsernameNotFoundException("user not found");
        }
        // 授权
        List<Privileges> privileges = userService.getUserPrivileges(account);
        List<SimpleGrantedAuthority> authorities =
                privileges.stream().map(p -> new SimpleGrantedAuthority(p.getPrivilegeCode())).collect(Collectors.toList());
        return new OauthAccountUserDetails(account, authorities);
    }

    /**
     * 从httpRequest中获取并验证客户端信息
     */
    public String getClientIdByRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) throw new UnsupportedOperationException();
        HttpServletRequest request = attributes.getRequest();
        UsernamePasswordAuthenticationToken client = authenticationConverter.convert(request);
        if (client == null) {
            throw new UnauthorizedClientException("unauthorized client");
        }
        ClientDetails clientDetails = jdbcClientDetailsService.loadClientByClientId(client.getName());
        if (!passwordEncoder.matches((String) client.getCredentials(), clientDetails.getClientSecret())) {
            throw new BadClientCredentialsException();
        }
        return clientDetails.getClientId();
    }
}