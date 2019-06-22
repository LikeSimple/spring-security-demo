package com.example.securitydemo.persistence.mapper;

import com.example.securitydemo.persistence.model.SystemResourceAuthority;
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
public interface SystemResourceAuthorityMapper {
    @Delete({
        "delete from system_resource_authority",
        "where resource_id = #{resourceId,jdbcType=CHAR}",
          "and authority_id = #{authorityId,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(@Param("resourceId") String resourceId, @Param("authorityId") String authorityId);

    @Insert({
        "insert into system_resource_authority (resource_id, authority_id, ",
        "created_time)",
        "values (#{resourceId,jdbcType=CHAR}, #{authorityId,jdbcType=CHAR}, ",
        "#{createdTime,jdbcType=TIMESTAMP})"
    })
    int insert(SystemResourceAuthority record);

    @Select({
        "select",
        "resource_id, authority_id, created_time",
        "from system_resource_authority",
        "where resource_id = #{resourceId,jdbcType=CHAR}",
          "and authority_id = #{authorityId,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="resource_id", property="resourceId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="authority_id", property="authorityId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SystemResourceAuthority selectByPrimaryKey(@Param("resourceId") String resourceId, @Param("authorityId") String authorityId);

    @Select({
        "select",
        "resource_id, authority_id, created_time",
        "from system_resource_authority",
        "order by username"
    })
    @Results({
        @Result(column="resource_id", property="resourceId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="authority_id", property="authorityId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SystemResourceAuthority> selectAll();

    @Update({
        "update system_resource_authority",
        "set created_time = #{createdTime,jdbcType=TIMESTAMP}",
        "where resource_id = #{resourceId,jdbcType=CHAR}",
          "and authority_id = #{authorityId,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(SystemResourceAuthority record);
}