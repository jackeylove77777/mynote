package com.itheima;

import com.itheima.dao.OrderDao;
import com.itheima.dao.OrderDao2;
import com.itheima.dao.UserDao;
import com.itheima.dao.UserDao2;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {
    SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
    }
    @After
    public void destory(){
        sqlSession.close();
    }

    @Test
    public void testResultMap(){
        //修改表中的列表，看看会出现什么问题？可以用什么办法解决
        OrderDao2 orderDao = sqlSession.getMapper(OrderDao2.class);
        UserDao2 userDao2 = sqlSession.getMapper(UserDao2.class);
        User user = userDao2.selectById(2);
        System.out.println(user.getBirthday());
//        System.out.println(user.getOrderList());


//        System.out.println(userDao2.selectById(1));
//        System.out.println(orderDao.selectById(2));
//        System.out.println(orderDao.selectById(2));


    }
    @Test
    public void testResultMap2(){
        //修改表中的列表，看看会出现什么问题？可以用什么办法解决
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.selectAll();
        for (User user : users) {
            System.out.println(user);
        }


    }
}
