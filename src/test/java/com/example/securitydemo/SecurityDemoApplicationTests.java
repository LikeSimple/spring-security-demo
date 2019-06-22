package com.example.securitydemo;

import com.example.securitydemo.persistence.mapper.*;
import com.example.securitydemo.persistence.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityDemoApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Autowired
    private SystemRoleMapper systemRoleMapper;

    @Autowired
    private SystemUserRoleMapper systemUserRoleMapper;

    @Autowired
    private SystemAuthorityMapper systemAuthorityMapper;

    @Autowired
    private SystemRoleAuthorityMapper systemRoleAuthorityMapper;

    @Test
//    @Transactional
    public void contextLoads() {

        //Add User
        SystemUser systemuser = new SystemUser("admin", passwordEncoder.encode("123456"));
        Assert.isTrue(1 == systemUserMapper.insert(systemuser), "insert system user failed");

        //Add Role
        SystemRole systemRole = new SystemRole("ROLE_ADMIN","for test");
        systemRoleMapper.insert(systemRole);

        //Add Authority
        SystemAuthority systemAuthority = new SystemAuthority("ROLE_ADMIN", "for test");
        systemAuthorityMapper.insert(systemAuthority);

        //Add User Role
        SystemUserRole systemUserRole = new SystemUserRole(systemuser, systemRole);
        systemUserRoleMapper.insert(systemUserRole);

        //Add Role Authority
        SystemRoleAuthority systemRoleAuthority = new SystemRoleAuthority(systemRole, systemAuthority);
        systemRoleAuthorityMapper.insert(systemRoleAuthority);
    }

}
