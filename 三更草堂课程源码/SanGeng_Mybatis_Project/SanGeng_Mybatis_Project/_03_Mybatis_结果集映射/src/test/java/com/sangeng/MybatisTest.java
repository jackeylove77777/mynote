package com.sangeng;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sangeng.dao.OrderDao;
import com.sangeng.dao.UserDao;
import com.sangeng.pojo.Order;
import com.sangeng.pojo.User;
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

public class MybatisTest {

    private SqlSession session;

    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //传入对应配置文件的输入流，读取配置文件获得SqlSessionFactory对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过SqlSessionFactory获取SqlSession(理解为是一个数据库连接)
        session = sqlSessionFactory.openSession();
    }

    @Test
    public void testUserDao(){

        UserDao userDao = session.getMapper(UserDao.class);
//        System.out.println(userDao.findAll());
        User user = userDao.findById(2);
//        System.out.println(user);
        User pdd = userDao.findByUsername("pdd");
        System.out.println(pdd.getId());
        System.out.println(pdd.getRoles());
//        System.out.println(pdd);
    }
    @Test
    public void testOrderDao(){
        //定义 OrderDao 定义查询所有订单的方法，观察属性映射有没有问题。思考如何解决
        OrderDao orderDao = session.getMapper(OrderDao.class);
//        System.out.println(orderDao.findAll());
//        Order order = orderDao.findById(2);
//        System.out.println(order);
    }

    @Test
    public void testPageHelper(){
        UserDao userDao = session.getMapper(UserDao.class);
        //设置分页查询参数
        PageHelper.startPage(1,1);
        List<User> list = userDao.findAll();
        System.out.println(list.get(0));
        PageInfo pageInfo = new PageInfo<User>(list);
        int pageNum = pageInfo.getPageNum();//总页数
        long total = pageInfo.getTotal();//总条数
        System.out.println(pageNum);
    }


    @Test
    public void testCache(){
        UserDao userDao = session.getMapper(UserDao.class);
        User user = userDao.findById(2);
        System.out.println(user);
        session.close();

//        userDao.delete(2);

        session = sqlSessionFactory.openSession();
        UserDao userDao2 = session.getMapper(UserDao.class);
        User user2 = userDao2.findById(2);
        System.out.println(user2);
    }

//    @After
    public void destory(){
        //提交事务，释放资源
        session.commit();
        session.close();
    }
}
