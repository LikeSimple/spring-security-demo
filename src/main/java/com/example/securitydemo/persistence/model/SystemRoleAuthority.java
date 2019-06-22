package com.example.securitydemo.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class SystemRoleAuthority implements Serializable {
    private String roleId;

    private String authorityId;

    private Date createdTime;

    public SystemRoleAuthority(SystemRole systemRole, SystemAuthority systemAuthority) {
        this.roleId = systemRole.getId();
        this.authorityId = systemAuthority.getId();
        this.createdTime = new Date();
    }

    private static final long serialVersionUID = 1L;
}