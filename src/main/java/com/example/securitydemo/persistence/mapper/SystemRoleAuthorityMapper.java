package com.example.securitydemo.persistence.mapper;

import com.example.securitydemo.persistence.model.SystemRoleAuthority;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface SystemRoleAuthorityMapper {
    @Delete({
        "delete from system_role_authority",
        "where role_id = #{roleId,jdbcType=CHAR}",
          "and authority_id = #{authorityId,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("authorityId") String authorityId);

    @Insert({
        "insert into system_role_authority (role_id, authority_id, ",
        "created_time)",
        "values (#{roleId,jdbcType=CHAR}, #{authorityId,jdbcType=CHAR}, ",
        "#{createdTime,jdbcType=TIMESTAMP})"
    })
    int insert(SystemRoleAuthority record);

    @Select({
        "select",
        "role_id, authority_id, created_time",
        "from system_role_authority",
        "where role_id = #{roleId,jdbcType=CHAR}",
          "and authority_id = #{authorityId,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="authority_id", property="authorityId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SystemRoleAuthority selectByPrimaryKey(@Param("roleId") String roleId, @Param("authorityId") String authorityId);

    @Select({
        "select",
        "role_id, authority_id, created_time",
        "from system_role_authority",
        "order by username"
    })
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="authority_id", property="authorityId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SystemRoleAuthority> selectAll();

    @Update({
        "update system_role_authority",
        "set created_time = #{createdTime,jdbcType=TIMESTAMP}",
        "where role_id = #{roleId,jdbcType=CHAR}",
          "and authority_id = #{authorityId,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(SystemRoleAuthority record);
}