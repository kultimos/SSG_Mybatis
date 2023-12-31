package com.kul.pojo.test;

import com.kul.pojo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {


    @Test
    public void me() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sql的会话对象SqlSession,MyBatis提供的操作数据库的对象,参数true表示自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用Mapper接口的方法，实现添加用户信息的功能
        int result = userMapper.insertUser();
//        System.out.println("结果：" + result);
//        userMapper.updateUser();

//        List<User> useList = userMapper.selectAll("kultimos");
//        System.out.println(useList);
//        User kultimos = userMapper.checkLogin("kultimos", "123456");
//        Map<String, Object> map = new HashMap<>();
//        map.put("userName", "kultimos");
//        map.put("password", "123456");
//        User user = userMapper.checkLoginByMap(map);
////        System.out.println(user);
//        User user = userMapper.selectById(User.builder().id(1).build());
//        System.out.println(user);
        //提交事务
//        sqlSession.commit();
        //关闭会话
        sqlSession.close();
    }
}

