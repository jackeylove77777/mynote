package com.sangeng.controller;

import com.sangeng.domain.Student;
import com.sangeng.domain.Student2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//@Controller
//@ResponseBody
@RestController//相当于@Controll+@ResponseBody
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${date}")
    private Date date;

    @Value("${student.age}")
    private Integer age;


    @Autowired
    private Student2 stu2;

    @Autowired
    private Student stu;

    @RequestMapping("/hello")
    public String hello(){
        return "HelloSpringBoot";
    }

    @RequestMapping("/test3")
    public String test(){
        System.out.println(name);
        return "test";
    }

}
