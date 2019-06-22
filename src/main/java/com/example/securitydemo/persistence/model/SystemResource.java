package com.example.securitydemo.persistence.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SystemResource implements Serializable {
    private String id;

    private String name;

    private String serialKey;

    private String url;

    private String icon;

    private String remark;

    private Boolean enabled;

    private Date createdTime;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;
}