package com.example.securitydemo.persistence.model;

import com.example.securitydemo.common.ShortUUIDGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "username")
public class SystemUser implements Serializable {

    private String id;

    private String username;

    private String password;

    private Boolean enabled;

    private Boolean locked;

    private Date accountExpire;

    private Date credentialExpire;

    private Date createdTime;

    private Date modifiedTime;

    private static final long serialVersionUID = -6439009994786040038L;

    public SystemUser(String username, String password) {

        this.id = ShortUUIDGenerator.newID();

        this.username = username;

        this.password = password;

        this.enabled = true;

        this.locked = false;

        this.createdTime = new Date();
    }

}