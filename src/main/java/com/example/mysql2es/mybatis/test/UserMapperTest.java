package com.example.mysql2es.mybatis.test;

import com.example.mysql2es.mybatis.mapper.UserMapper;
import com.example.mysql2es.mybatis.model.SysRole;
import com.example.mysql2es.mybatis.model.SysRoleExtends;
import com.example.mysql2es.mybatis.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 * @Author: admin
 * @Description:
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.mybatis.test
 * @CreateTime: 2020-11-18 20:39:04
 */
public class UserMapperTest extends BaseMapperTest{

    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = mapper.selectById(1L);
            Assert.assertNotNull(sysUser);
            Assert.assertEquals("admin", sysUser.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> sysUser = mapper.selectAll();
            Assert.assertNotNull(sysUser);
            Assert.assertTrue(!sysUser.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRoleByUserId(){
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> sysRole = mapper.selectRoleByUserId(1L);
            Assert.assertNotNull(sysRole);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRoleByUserIdExtends(){
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<SysRoleExtends> sysRole = mapper.selectRoleByUserIdExtends(1L);
            for (SysRoleExtends role : sysRole) {
                System.out.println(role);
            }
            Assert.assertNotNull(sysRole);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert(){
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("usertest");
            user.setUserPassword("passtest");
            user.setUserEmail("email@mybatis.org");
            user.setUserInfo("infotest");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            int insert = mapper.insert(user);
            Assert.assertEquals(1, insert);
            Assert.assertNull(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2(){
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("usertest");
            user.setUserPassword("passtest");
            user.setUserEmail("email@mybatis.org");
            user.setUserInfo("infotest");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            int insert = mapper.insert2(user);
            Assert.assertEquals(1, insert);
            System.out.println("返回的自增主键是："+user.getId());
            Assert.assertNotNull(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert3(){
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("usertest");
            user.setUserPassword("passtest");
            user.setUserEmail("email@mybatis.org");
            user.setUserInfo("infotest");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            int insert = mapper.insert3(user);
            Assert.assertEquals(1, insert);
            System.out.println("返回的自增主键是："+user.getId());
            Assert.assertNotNull(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateById(){
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = mapper.selectById(1L);
            user.setUserName("administrator");
            user.setUserEmail("mysql@mybatis.org");
            user.setUpdateTime(new Date());
            int result = mapper.updateById(user);
            Assert.assertEquals(1, result);
            SysUser updateUser = mapper.selectById(1L);
            System.out.println("更新后的User："+updateUser);
            Assert.assertEquals("administrator", user.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}