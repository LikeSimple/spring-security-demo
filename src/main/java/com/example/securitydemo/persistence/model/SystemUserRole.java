package com.example.securitydemo.persistence.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SystemUserRole implements Serializable {

    private String systemUserId;

    private String roleId;

    private Date createdTime;

    public SystemUserRole(SystemUser systemUser, SystemRole systemRole) {

        this.systemUserId = systemUser.getId();

        this.roleId = systemRole.getId();

        this.createdTime = new Date();
    }

    private static final long serialVersionUID = 1L;
}