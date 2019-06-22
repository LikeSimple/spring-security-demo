CREATE DATABASE IF NOT EXISTS security_demo DEFAULT CHARACTER SET = utf8mb4 DEFAULT COLLATE = utf8mb4_general_ci;

create table if not exists system_authority
(
    id char(22) not null
        primary key,
    name varchar(40) not null,
    `desc` varchar(200) null,
    created_time datetime default CURRENT_TIMESTAMP not null,
    modified_time datetime null,
    constraint name
        unique (name)
)
    comment '系统权限';

create table if not exists  system_resource
(
    id char(22) not null
        primary key,
    name varchar(30) not null,
    serial_key varchar(6) not null,
    url varchar(100) not null,
    icon varchar(40) null,
    remark varchar(100) default '' not null,
    enabled tinyint(1) default 1 not null,
    created_time datetime default CURRENT_TIMESTAMP not null,
    modified_time datetime null,
    constraint name
        unique (name),
    constraint serial_key
        unique (serial_key)
)
    comment '系统资源';

create table if not exists  system_resource_authority
(
    resource_id char(22) not null,
    authority_id char(22) not null,
    created_time datetime default CURRENT_TIMESTAMP not null,
    primary key (resource_id, authority_id)
)
    comment '系统资源权限';

create table if not exists system_role
(
    id char(22) not null
        primary key,
    name char(40) not null,
    description varchar(200) null,
    created_time datetime default CURRENT_TIMESTAMP not null,
    modified_time datetime null,
    constraint name
        unique (name)
)
    comment '系统角色';

create table if not exists system_role_authority
(
    role_id char(22) not null,
    authority_id char(22) not null,
    created_time datetime default CURRENT_TIMESTAMP not null,
    primary key (role_id, authority_id)
)
    comment '系统角色权限';

create table if not exists system_user
(
    id char(22) not null
        primary key,
    username varchar(30) not null,
    password char(60) not null,
    enabled tinyint(1) default 1 not null,
    locked tinyint(1) default 0 not null,
    account_expire datetime null,
    credential_expire datetime null,
    created_time datetime default CURRENT_TIMESTAMP not null,
    modified_time datetime null,
    constraint username
        unique (username)
)
    comment '系统管理员';

create table if not exists  system_user_role
(
    system_user_id char(22) not null,
    role_id char(22) not null,
    created_time datetime default CURRENT_TIMESTAMP not null,
    primary key (system_user_id, role_id)
)
    comment '系统管理员角色';

