package com.sangeng;

import com.sangeng.controller.HelloController;
//import org.junit.jupiter.api.Test;
import com.sangeng.domain.User;
import com.sangeng.mapper.UserMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//classes属性来指定启动类
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private HelloController helloController;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testJunit(){
        System.out.println(1);
        System.out.println(helloController);
    }

    @Test
    public void testMapper(){
        List<User> users = userMapper.findAll();
        System.out.println(users);
    }
}
