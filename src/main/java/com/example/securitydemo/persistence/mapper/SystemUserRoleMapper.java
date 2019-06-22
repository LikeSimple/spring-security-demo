package com.example.securitydemo.persistence.mapper;

import com.example.securitydemo.persistence.model.SystemUserRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface SystemUserRoleMapper {
    @Delete({
        "delete from system_user_role",
        "where system_user_id = #{systemUserId,jdbcType=CHAR}",
          "and role_id = #{roleId,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(@Param("systemUserId") String systemUserId, @Param("roleId") String roleId);

    @Insert({
        "insert into system_user_role (system_user_id, role_id, ",
        "created_time)",
        "values (#{systemUserId,jdbcType=CHAR}, #{roleId,jdbcType=CHAR}, ",
        "#{createdTime,jdbcType=TIMESTAMP})"
    })
    int insert(SystemUserRole record);

    @Select({
        "select",
        "system_user_id, role_id, created_time",
        "from system_user_role",
        "where system_user_id = #{systemUserId,jdbcType=CHAR}",
          "and role_id = #{roleId,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="system_user_id", property="systemUserId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SystemUserRole selectByPrimaryKey(@Param("systemUserId") String systemUserId, @Param("roleId") String roleId);

    @Select({
        "select",
        "system_user_id, role_id, created_time",
        "from system_user_role",
        "order by username"
    })
    @Results({
        @Result(column="system_user_id", property="systemUserId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SystemUserRole> selectAll();

    @Update({
        "update system_user_role",
        "set created_time = #{createdTime,jdbcType=TIMESTAMP}",
        "where system_user_id = #{systemUserId,jdbcType=CHAR}",
          "and role_id = #{roleId,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(SystemUserRole record);
}