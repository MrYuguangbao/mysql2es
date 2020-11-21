package com.example.mysql2es.mybatis.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: admin
 * @Description: 角色实体类
 * @BelongsProject: demo
 * @BelongsPackage: com.example.demo.mybatis.model
 * @CreateTime: 2020-11-17 23:28:39
 */
@Data
@ToString
public class SysRole {

    private Long id;
    private String roleName;
    private Enabled enabled;
    //private Integer enabled;
    // 使用CreateInfo代替存储
    /*private Long createBy;
    private LocalDateTime createTime;*/
    private CreateInfo createInfo;
    private LocalDateTime updateTime;

    /**
     * 角色的权限集合
     */
    private List<SysPrivilege> privilegeList;

}
