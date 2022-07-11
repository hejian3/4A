package com.hj.fa.config;


import com.hj.fa.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class OauthAccountUserDetails implements UserDetails {

    public OauthAccountUserDetails(User user, Collection<? extends GrantedAuthority> authorities) {
        this.oauthAccount = user;
        this.authorities = authorities;
    }

    private final User oauthAccount;

    private final Collection<? extends GrantedAuthority> authorities;

    public User getOauthAccount() {
        return oauthAccount;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return oauthAccount.getPassword();
    }

    @Override
    public String getUsername() {
        return oauthAccount.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return oauthAccount.getAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return oauthAccount.getAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return oauthAccount.getCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return oauthAccount.getEnabled();
    }
}
