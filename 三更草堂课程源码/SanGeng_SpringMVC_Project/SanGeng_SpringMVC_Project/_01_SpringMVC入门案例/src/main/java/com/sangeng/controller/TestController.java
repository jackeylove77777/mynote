package com.sangeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")  //  /test/testPath
public class TestController {


    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println("hello");
        System.out.println(name);
        return "/success.jsp";
    }

    @RequestMapping("/testPath")
    public ModelAndView testPath(){
        System.out.println("testPath");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","三更");
        modelAndView.setViewName("/success.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/testMethod",method = RequestMethod.POST)
//    @PostMapping("/testMethod")
    public String testMethod(){
        System.out.println("testMethod");
        return "/success.jsp";
    }

    @RequestMapping(value = "/testParams",method = RequestMethod.GET,params = "code!=sgct")
    public String testParams(){
        System.out.println("testParams");
        return "/success.jsp";
    }

    @RequestMapping(value = "/testHeaders",method = RequestMethod.GET,headers = "deviceType!=ios")
    public String testHeaders(){
        System.out.println("testHeaders");
        return "/success.jsp";
    }

    @RequestMapping(value = "/testConsumes",method = RequestMethod.POST,consumes = "multipart/from-data")
    public String testConsumes(){
        System.out.println("testConsumes");
        return "/success.jsp";
    }
}
