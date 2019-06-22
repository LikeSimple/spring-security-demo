package com.example.securitydemo.persistence.mapper;

import com.example.securitydemo.persistence.model.SystemResource;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface SystemResourceMapper {
    @Delete({
        "delete from system_resource",
        "where id = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into system_resource (id, name, serial_key, ",
        "url, icon, remark, ",
        "enabled, created_time, ",
        "modified_time)",
        "values (#{id,jdbcType=CHAR}, #{name,jdbcType=VARCHAR}, #{serialKey,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{icon,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{enabled,jdbcType=BIT}, #{createdTime,jdbcType=TIMESTAMP}, ",
        "#{modifiedTime,jdbcType=TIMESTAMP})"
    })
    int insert(SystemResource record);

    @Select({
        "select",
        "id, name, serial_key, url, icon, remark, enabled, created_time, modified_time",
        "from system_resource",
        "where id = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="serial_key", property="serialKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modified_time", property="modifiedTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SystemResource selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, name, serial_key, url, icon, remark, enabled, created_time, modified_time",
        "from system_resource",
        "order by username"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="serial_key", property="serialKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modified_time", property="modifiedTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SystemResource> selectAll();

    @Update({
        "update system_resource",
        "set name = #{name,jdbcType=VARCHAR},",
          "serial_key = #{serialKey,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "enabled = #{enabled,jdbcType=BIT},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "modified_time = #{modifiedTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(SystemResource record);
}