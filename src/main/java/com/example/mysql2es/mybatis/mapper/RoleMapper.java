package com.example.mysql2es.mybatis.mapper;

import com.example.mysql2es.mybatis.model.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: admin
 * @Description: 角色mapper接口
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.mybatis.mapper
 * @CreateTime: 2020-11-20 18:27:20
 */
public interface RoleMapper {
    @Select({"select id,role_name,enabled,update_time",
    "from sys_role",
    "where id = #{id}"})
    SysRole selectById(Long id);

    SysRole selectRoleById(Long id);

    List<SysRole> selectAllRoleAndPrivileges();

    List<SysRole> selectRoleByUserIdChoose(Long userId);

    @Results(id = "roleResultMap", value = {
            @Result(property = "id",column = "id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    @Select({"select id,role_name,enabled,create_by,create_time,update_time from " +
            "sys_role where id = #{id}"})
    SysRole selectById2(Long id);

    @ResultMap("roleResultMap")
    @Select("select * from sys_role")
    List<SysRole> selectAll();

    @Insert({
            "insert into sys_role(role_name,enabled,create_by,create_time,update_time) " +
                    "values(#{roleName},#{enabled},#{createBy}" +
                    ",#{createTime,jdbcType=TIMESTAMP},#{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(SysRole sysRole);

    @Insert({
            "insert into sys_role(role_name,enabled,create_by,create_time,update_time) " +
                    "values(#{roleName},#{enabled},#{createBy}" +
                    ",#{createTime,jdbcType=TIMESTAMP},#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement = "select last_insert_id()",
                keyProperty = "id",
                resultType = Long.class,
                before = false)
    int insert3(SysRole sysRole);

    @Update("update sys_role set enabled = #{enabled} where id = #{id}")
    int updateById(SysRole sysRole);

}
