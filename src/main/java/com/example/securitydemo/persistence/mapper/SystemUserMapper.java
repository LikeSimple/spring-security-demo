package com.example.securitydemo.persistence.mapper;

import com.example.securitydemo.persistence.model.SystemUser;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface SystemUserMapper {
    @Delete({
        "delete from system_user",
        "where id = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into system_user (id, username, ",
        "password, enabled, locked, ",
        "account_expire, credential_expire, ",
        "created_time, modified_time)",
        "values (#{id,jdbcType=CHAR}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=CHAR}, #{enabled,jdbcType=BIT}, #{locked,jdbcType=BIT}, ",
        "#{accountExpire,jdbcType=TIMESTAMP}, #{credentialExpire,jdbcType=TIMESTAMP}, ",
        "#{createdTime,jdbcType=TIMESTAMP}, #{modifiedTime,jdbcType=TIMESTAMP})"
    })
    int insert(SystemUser record);

    @Select({
        "select",
        "id, username, password, enabled, locked, account_expire, credential_expire, ",
        "created_time, modified_time",
        "from system_user",
        "where id = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.CHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
        @Result(column="locked", property="locked", jdbcType=JdbcType.BIT),
        @Result(column="account_expire", property="accountExpire", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="credential_expire", property="credentialExpire", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modified_time", property="modifiedTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SystemUser selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, username, password, enabled, locked, account_expire, credential_expire, ",
        "created_time, modified_time",
        "from system_user",
        "order by username"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.CHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
        @Result(column="locked", property="locked", jdbcType=JdbcType.BIT),
        @Result(column="account_expire", property="accountExpire", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="credential_expire", property="credentialExpire", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modified_time", property="modifiedTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SystemUser> selectAll();

    @Update({
        "update system_user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=CHAR},",
          "enabled = #{enabled,jdbcType=BIT},",
          "locked = #{locked,jdbcType=BIT},",
          "account_expire = #{accountExpire,jdbcType=TIMESTAMP},",
          "credential_expire = #{credentialExpire,jdbcType=TIMESTAMP},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "modified_time = #{modifiedTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(SystemUser record);

    @Select({
            "select",
            "id, username, password, enabled, locked, account_expire, credential_expire, ",
            "created_time, modified_time",
            "from system_user",
            "where username = #{username,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.CHAR),
            @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
            @Result(column="locked", property="locked", jdbcType=JdbcType.BIT),
            @Result(column="account_expire", property="accountExpire", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="credential_expire", property="credentialExpire", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="modified_time", property="modifiedTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SystemUser selectByUsername(@Param("username") String username);
}