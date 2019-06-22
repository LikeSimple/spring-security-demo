package com.example.securitydemo.persistence.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SystemResourceAuthority implements Serializable {
    private String resourceId;

    private String authorityId;

    private Date createdTime;

    private static final long serialVersionUID = 1L;
}