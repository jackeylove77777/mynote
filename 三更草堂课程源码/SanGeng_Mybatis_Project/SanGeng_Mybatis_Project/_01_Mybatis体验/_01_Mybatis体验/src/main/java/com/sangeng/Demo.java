package com.sangeng;

import com.sangeng.dao.UserDao;
import com.sangeng.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {
        UserDao userDao = getMapper();
//        List<User> users = userDao.findAll();
        User user = userDao.findUser();
        System.out.println(user);
//        for (User user : users) {
//            System.out.println(user);
//        }
    }

    private static UserDao getMapper() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        return mapper;
    }
}
