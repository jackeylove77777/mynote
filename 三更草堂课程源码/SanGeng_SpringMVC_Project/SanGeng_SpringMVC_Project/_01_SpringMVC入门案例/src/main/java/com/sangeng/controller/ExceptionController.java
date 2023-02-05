package com.sangeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    @RequestMapping("/testException")
    public String testException(){
        System.out.println(1/0);
        return "/success.jsp";
    }
}
