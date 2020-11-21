package com.example.mysql2es.mybatis.mapper;

import com.example.mysql2es.mybatis.model.SysRole;
import com.example.mysql2es.mybatis.model.SysRoleExtends;
import com.example.mysql2es.mybatis.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.net.SSLUtil;

import java.util.List;
import java.util.Map;

/**
 * @Author: admin
 * @Description: 用户Mapper
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.mybatis.mapper
 * @CreateTime: 2020-11-18 19:36:21
 */
public interface UserMapper {
    /**
     * 通过ID查询用户
     * @param id
     * @return
     */
    SysUser selectById(Long id);

    /**
     * 查询全部用户
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 根据用户id获取角色信息
     * @param userId
     * @return
     */
    List<SysRole> selectRoleByUserId(Long userId);

    /**
     * 根据用户id获取角色信息（扩展）
     * @param userId
     * @return
     */
    List<SysRoleExtends> selectRoleByUserIdExtends(Long userId);

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);

    /**
     * 新增用户2 - 使用JDBC方式获取自增主键
     * @param sysUser
     * @return
     */
    int insert2(@Param("sysUser") SysUser sysUser);

    /**
     * 新增用户3 - 使用selectKey获取自增主键
     * @param sysUser
     * @return
     */
    int insert3(SysUser sysUser);

    /**
     * 根据主键更新
     * @param sysUser
     * @return
     */
    int updateById(SysUser sysUser);

    /**
     * 根据enabled和用户id查询用户的所有角色
     * @param userId
     * @param enabled
     * @return
     */
    List<SysRole> selectRolesByIdAndEnable(@Param("userId") Long userId, @Param("enabled") Integer enabled);

    /**
     * 根据enabled和用户id查询用户的所有角色
     * @param sysUser
     * @param sysRole
     * @return
     */
    List<SysRole> selectRolesByIdAndEnable2(SysUser sysUser,SysRole sysRole);

    /**
     * 根据id集合查询用户-参数是list集合
     * @param idList
     * @return
     */
    List<SysUser> selectUsersByIdlist(@Param("myList") List<Long> idList);

    /**
     * 根据id集合查询用户-参数是数组
     * @param idList
     * @return
     */
    List<SysUser> selectUsersByIdlist2(@Param("myArray") Long[] idList);

    /**
     * 批量新增用户
     * @param userList
     * @return
     */
    int insertUserBatch(List<SysUser> userList);

    /**
     * 通过map更新列
     * @param map
     * @return
     */
    int updateByMap(Map<String, Object> map);

    /**
     * 在where中使用if
     * @param sysUser
     * @return
     */
    List<SysUser> selectUserByIf1(SysUser sysUser);

    /**
     * 根据主键更新
     * @param sysUser
     * @return
     */
    int updateByIdSelective(SysUser sysUser);

    SysUser selectByIdOrUserName(SysUser sysUser);

    SysUser selectByIdOrUserName1(SysUser sysUser);

    SysUser selectUserAndRoleById(Long id);

    SysUser selectUserAndRoleById2(Long id);

    SysUser selectUserAndRoleById3(Long id);

    SysUser selectUserAndRoleByIdSelect(Long id);

    List<SysUser> selectAllUserAndRoles();

    SysUser selectAllUserAndRoleSelect(Long id);

}
