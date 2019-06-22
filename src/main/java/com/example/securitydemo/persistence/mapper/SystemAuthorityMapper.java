package com.example.securitydemo.persistence.mapper;

import com.example.securitydemo.persistence.model.SystemAuthority;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface SystemAuthorityMapper {
    @Delete({
        "delete from system_authority",
        "where id = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into system_authority (id, name, description, ",
        "created_time, modified_time)",
        "values (#{id,jdbcType=CHAR}, #{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{createdTime,jdbcType=TIMESTAMP}, #{modifiedTime,jdbcType=TIMESTAMP})"
    })
    int insert(SystemAuthority record);

    @Select({
        "select",
        "id, name, description, created_time, modified_time",
        "from system_authority",
        "where id = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column= "description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modified_time", property="modifiedTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SystemAuthority selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, name, description, created_time, modified_time",
        "from system_authority",
        "order by username"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column= "description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modified_time", property="modifiedTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SystemAuthority> selectAll();

    @Update({
        "update system_authority",
        "set name = #{name,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "modified_time = #{modifiedTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(SystemAuthority record);

    @Select({
            "select",
            "system_authority.id, system_authority.name, system_authority.description, system_authority.created_time, system_authority.modified_time",
            "from system_authority",
            "inner join system_role_authority on system_authority.id = system_role_authority.authority_id",
            "inner join system_user_role on system_role_authority.role_id = system_user_role.role_id",
            "where system_user_role.system_user_id = #{id,jdbcType=CHAR}",
            "order by system_authority.name"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column= "description", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="modified_time", property="modifiedTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SystemAuthority> selectByUserId(@Param("id") String id);
}