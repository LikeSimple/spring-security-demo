package com.example.securitydemo.persistence.mapper;

import com.example.securitydemo.persistence.model.SystemRoleAuthority;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

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