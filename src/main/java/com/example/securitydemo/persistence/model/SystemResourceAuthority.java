package com.example.securitydemo.persistence.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SystemResourceAuthority implements Serializable {
    private String resourceId;

    private String authorityId;

    private Date createdTime;

    private static final long serialVersionUID = 1L;
}