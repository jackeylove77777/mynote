package com.sangeng;

import com.sangeng.dao.UserDao;
import com.sangeng.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //传入对应配置文件的输入流，读取配置文件获得SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过SqlSessionFactory获取SqlSession(理解为是一个数据库连接)
        SqlSession session = sqlSessionFactory.openSession();

        //通过SqlSessionFactory获取dao接口的实现类对象，
        UserDao userDao = session.getMapper(UserDao.class);
//        Integer[] ids = {1,2,3,4,5,6};
//        System.out.println(userDao.findByIds(ids));

        //测试choose
//        System.out.println(
//                userDao.selectChose(
//                        new User(null, null, 20, null)));


//        System.out.println(userDao.findById(2));
        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user);
        }

//        User user = userDao.findByUser(new User(2, "'pdd'", 16, "'北京'"));
//        System.out.println(user);

//        List<User> users = userDao.findByCondition(null, null);
//        System.out.println(users);

        //测试插入数据
//        userDao.insertUser(new User(null,"若风",35,"上海"));

//        测试删除数据
//        userDao.deleteById(32);

//        测试更新数据
//        userDao.updateUser(new User(2,"pdd",null,null));

//        System.out.println(userDao.findById(2));
        //提交事务
        session.commit();
        //释放资源
        session.close();
    }

}
