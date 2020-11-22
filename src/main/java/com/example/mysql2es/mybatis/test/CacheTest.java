package com.example.mysql2es.mybatis.test;

import com.example.mysql2es.mybatis.mapper.UserMapper;
import com.example.mysql2es.mybatis.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: admin
 * @Description: 一级缓存测试
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.mybatis.test
 * @CreateTime: 2020-11-21 23:45:30
 */
public class CacheTest extends BaseMapperTest {

    @Test
    public void testL1Cache(){
        SqlSession sqlSession = getSqlsession();
        SysUser sysUser = null;
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            sysUser = mapper.selectById(1L);
            sysUser.setUserName("new username");

            SysUser sysUser1 = mapper.selectById(1L);
            Assert.assertEquals("new username", sysUser1.getUserName());
            Assert.assertEquals(sysUser, sysUser1);

        } finally {
            sqlSession.close();
        }
        System.out.println("---开启新的sqlsession");
        sqlSession = getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser2 = mapper.selectById(1L);
            Assert.assertNotEquals("new username", sysUser2.getUserName());
            Assert.assertNotEquals(sysUser, sysUser2);

            int del = mapper.deleteById(2L);
            SysUser sysUser3 = mapper.selectById(1L);
            Assert.assertNotEquals(sysUser2, sysUser3);

        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }









    }


}
