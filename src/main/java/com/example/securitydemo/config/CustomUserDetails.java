package com.example.securitydemo.config;

import com.example.securitydemo.persistence.model.SystemAuthority;
import com.example.securitydemo.persistence.model.SystemUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private SystemUser systemUser;

    private List<SystemAuthority> systemAuthorityList;

    public CustomUserDetails(SystemUser systemUser, List<SystemAuthority> systemAuthorityList) {
        this.systemUser = systemUser;
        this.systemAuthorityList = systemAuthorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return systemAuthorityList.stream().map(SystemAuthority::getName).map(CustomGrantedAuthority::new).collect(Collectors.toList());

    }

    @Override
    public String getPassword() {
        return systemUser.getPassword();
    }

    @Override
    public String getUsername() {
        return systemUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return systemUser.getAccountExpire() == null || systemUser.getAccountExpire().after(new Date());
    }

    @Override
    public boolean isAccountNonLocked() {
        return !systemUser.getLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return systemUser.getCredentialExpire() == null || systemUser.getCredentialExpire().after(new Date());
    }

    @Override
    public boolean isEnabled() {
        return systemUser.getEnabled();
    }

    public static class CustomGrantedAuthority implements GrantedAuthority {

        private String authority;

        public CustomGrantedAuthority(String authority) {
            this.authority = authority;
        }

        @Override
        public String getAuthority() {
            return authority;
        }
    }
}
