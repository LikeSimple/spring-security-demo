package com.example.securitydemo.persistence.model;

import com.example.securitydemo.common.ShortUUIDGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class SystemAuthority implements Serializable {

    private String id;

    private String name;

    private String description;

    private Date createdTime;

    private Date modifiedTime;

    public SystemAuthority(String name, String description) {

        id = ShortUUIDGenerator.newID();

        this.name = name;

        this.description = description;

        this.createdTime = new Date();

    }

    private static final long serialVersionUID = -6155385400970951688L;
}