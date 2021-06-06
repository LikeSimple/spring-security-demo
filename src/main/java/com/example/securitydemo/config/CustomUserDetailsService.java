package com.example.securitydemo.config;

import com.example.securitydemo.persistence.mapper.SystemAuthorityMapper;
import com.example.securitydemo.persistence.mapper.SystemUserMapper;
import com.example.securitydemo.persistence.model.SystemAuthority;
import com.example.securitydemo.persistence.model.SystemUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Configuration
public class CustomUserDetailsService implements UserDetailsService {

    final private SystemUserMapper systemUserMapperImpl;

    final private SystemAuthorityMapper systemAuthorityMapper;

    public CustomUserDetailsService(SystemUserMapper systemUserMapperImpl, SystemAuthorityMapper systemAuthorityMapper) {
        this.systemUserMapperImpl = systemUserMapperImpl;
        this.systemAuthorityMapper = systemAuthorityMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (null == username || "".equals(username)) {
            throw new UsernameNotFoundException("username is empty");
        }

        SystemUser systemUser = systemUserMapperImpl.selectByUsername(username);
        if (null == systemUser) {
            throw new UsernameNotFoundException("user " + username + " not find");
        }
        List<SystemAuthority> systemAuthoritieList = systemAuthorityMapper.selectByUserId(systemUser.getId());

        return new CustomUserDetails(systemUser, systemAuthoritieList);
    }

    @Bean("userDetailsService")
    public CustomUserDetailsService customUserDetailsService(SystemUserMapper systemUserMapper, SystemAuthorityMapper systemAuthorityMapper) {
        return new CustomUserDetailsService(systemUserMapper, systemAuthorityMapper);
    }
}
