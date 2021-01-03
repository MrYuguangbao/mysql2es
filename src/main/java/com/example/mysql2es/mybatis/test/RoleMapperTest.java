package com.example.mysql2es.mybatis.test;

import com.example.mysql2es.mybatis.mapper.RoleMapper;
import com.example.mysql2es.mybatis.mapper.UserMapper;
import com.example.mysql2es.mybatis.model.Enabled;
import com.example.mysql2es.mybatis.model.SysPrivilege;
import com.example.mysql2es.mybatis.model.SysRole;
import com.example.mysql2es.mybatis.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author: admin
 * @Description: 角色测试类
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.mybatis.test
 * @CreateTime: 2020-11-20 18:30:13
 */
public class RoleMapperTest extends BaseMapperTest {

    /*@Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlsession();
        try {
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = mapper.selectById(1L);
            Assert.assertEquals(Enabled.enabled, sysRole.getEnabled());
            System.out.println(sysRole);
            sysRole.setEnabled(Enabled.disabled);
            mapper.updateById(sysRole);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }*/

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlsession();
        try {
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> sysRoles = mapper.selectAll();
            sysRoles.forEach(v -> {
                System.out.println(v);
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    /*@Test
    public void testInsert2() {
        SqlSession sqlSession = getSqlsession();
        try {
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = new SysRole();
            sysRole.setRoleName("testrolename");
            sysRole.setEnabled(Enabled.enabled);
            *//*sysRole.setCreateBy(1L);
            sysRole.setCreateTime(LocalDateTime.now());*//*
            sysRole.setUpdateTime(LocalDateTime.now());
            int insertCount = mapper.insert2(sysRole);
            Assert.assertEquals(1, insertCount);
            System.out.println("生成的主键是:"+sysRole.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //sqlSession.rollback();
            sqlSession.commit();
            sqlSession.close();
        }
    }*/

    /*@Test
    public void testInsert3() {
        SqlSession sqlSession = getSqlsession();
        try {
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = new SysRole();
            sysRole.setRoleName("testrolename");
            sysRole.setEnabled(1);
            sysRole.setCreateBy(1L);
            sysRole.setCreateTime(LocalDateTime.now());
            sysRole.setUpdateTime(LocalDateTime.now());
            int insertCount = mapper.insert3(sysRole);
            Assert.assertEquals(1, insertCount);
            System.out.println("生成的主键是:"+sysRole.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }*/

    @Test
    public void testSelectAllRoleAndPrivileges() {
        SqlSession sqlSession = getSqlsession();
        try {
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> sysRoles = mapper.selectAllRoleAndPrivileges();
            for (SysRole sysRole : sysRoles) {
                System.out.println("角色名:" + sysRole.getRoleName());
                for (SysPrivilege sysPrivilege : sysRole.getPrivilegeList()) {
                    System.out.println("- 权限名:"+sysPrivilege.getPrivilegeName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRoleByUserIdChoose() {
        SqlSession sqlSession = getSqlsession();
        try {
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> sysRoles = mapper.selectRoleByUserIdChoose(1L);
            for (SysRole sysRole : sysRoles) {
                System.out.println("角色名:" + sysRole.getRoleName());
                /*if (sysRole.getId().equals(1L)) {
                    Assert.assertNotNull(sysRole.getPrivilegeList());
                } else if (sysRole.getId().equals(2L)) {
                    Assert.assertNull(sysRole.getPrivilegeList());
                    continue;
                }*/
                for (SysPrivilege sysPrivilege : sysRole.getPrivilegeList()) {
                    System.out.println("权限名:" + sysPrivilege.getPrivilegeName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testL2Cache() {
        SqlSession sqlSession = getSqlsession();
        SysRole role1 = null;
        try {
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            role1 = mapper.selectRoleById(1L);
            role1.setRoleName("new rolename");
            SysRole role2 = mapper.selectRoleById(1L);
            Assert.assertEquals("new rolename", role2.getRoleName());
            Assert.assertEquals(role1, role2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        System.out.println("---开启新的sqlsession");
        sqlSession = getSqlsession();
        try {
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role2 = mapper.selectRoleById(1L);
            Assert.assertEquals("new rolename", role2.getRoleName());
            Assert.assertEquals(role1, role2);
            SysRole role3 = mapper.selectRoleById(1L);
            Assert.assertEquals(role2, role3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }


    }
}
