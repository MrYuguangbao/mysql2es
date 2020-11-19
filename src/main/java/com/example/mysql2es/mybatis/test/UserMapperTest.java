package com.example.mysql2es.mybatis.test;

import com.example.mysql2es.mybatis.mapper.UserMapper;
import com.example.mysql2es.mybatis.model.SysRole;
import com.example.mysql2es.mybatis.model.SysRoleExtends;
import com.example.mysql2es.mybatis.model.SysUser;
import com.example.mysql2es.mybatis.proxy.MyMapperProxy;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.time.LocalDateTime;
import java.util.*;


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
            user.setUserName("usertest1");
            user.setUserPassword("passtest1");
            user.setUserInfo("infotest1");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            // TODO 不能新增到数据库
            int insert = mapper.insert2(user);
            Assert.assertEquals(1, insert);
            System.out.println("新增返回的主键是:"+user.getId());

            //SysUser user1 = mapper.selectById(user.getId());
            //Assert.assertEquals("default@mybatis.org", user1.getUserEmail());
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

    @Test
    public void testSelectRolesByIdAndEnable(){
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> sysRoles = mapper.selectRolesByIdAndEnable(1L, 1);
            Assert.assertNotNull(sysRoles);
            Assert.assertTrue(sysRoles.size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByIdAndEnable2(){
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = new SysUser();
            sysUser.setId(1L);
            SysRole sysRole = new SysRole();
            sysRole.setEnabled(1);

            List<SysRole> sysRoles = mapper.selectRolesByIdAndEnable2(sysUser, sysRole);
            Assert.assertNotNull(sysRoles);
            Assert.assertTrue(sysRoles.size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void selectUsersByIdlist(){
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<Long> idList = new ArrayList<>(Arrays.asList(1L,1001L));
            List<SysUser> sysUsers = mapper.selectUsersByIdlist(idList);
            Assert.assertEquals(2, sysUsers.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectUsersByIdlist2(){
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Long[] idArray = {1L, 1001L};
            List<SysUser> sysUsers = mapper.selectUsersByIdlist2(idArray);
            Assert.assertEquals(2, sysUsers.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsertUserBatch(){
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                SysUser user = new SysUser();
                user.setUserName("test" + i);
                user.setUserPassword("123");
                user.setUserEmail("test@mybatis.org");
                userList.add(user);
            }
            int insertResult = mapper.insertUserBatch(userList);
            System.out.println("批量新增完成之后，返回自增主键值");
            for (SysUser user : userList) {
                System.out.println(user.getId());
            }
            Assert.assertEquals(2, insertResult);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateByMap(){
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("id", 1L);
            map.put("user_email", "update@mybatis.org");
            map.put("user_password", "mybatis");
            int updateResult = mapper.updateByMap(map);
            Assert.assertEquals(1, updateResult);

            SysUser user = mapper.selectById(1L);
            System.out.println("根据id查询更新后的数据：" + user);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testMapperProxy(){
        SqlSession sqlSession = getSqlsession();
        try {
            MyMapperProxy mapperProxy = new MyMapperProxy(UserMapper.class, sqlSession);
            UserMapper userMapper = (UserMapper)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                    new Class[]{UserMapper.class},
                    mapperProxy);
            List<SysUser> userList = userMapper.selectAll();
            for (SysUser user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectUserByIf1(){
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            SysUser query = new SysUser();
            System.out.println("只根据用户名查询");
            query.setUserName("ad");
            List<SysUser> sysUsers = mapper.selectUserByIf1(query);
            Assert.assertTrue(sysUsers.size() > 0);

            query = new SysUser();
            System.out.println("只根据email查询");
            query.setUserEmail("admin@mybatis.com");
            sysUsers = mapper.selectUserByIf1(query);
            Assert.assertTrue(sysUsers.size() > 0);

            query = new SysUser();
            query.setUserName("ad");
            query.setUserEmail("test@mybatis.com");
            sysUsers = mapper.selectUserByIf1(query);
            Assert.assertTrue(sysUsers.size() == 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateByIdSelective(){
        SqlSession sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            SysUser update = new SysUser();
            update.setId(1001L);
            update.setUserEmail("update1@mybatis.org");
            int updateResult = mapper.updateByIdSelective(update);
            Assert.assertEquals(1, updateResult);

            update = mapper.selectById(1001L);
            Assert.assertEquals("test", update.getUserName());
            Assert.assertEquals("update1@mybatis.org", update.getUserEmail());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }



}