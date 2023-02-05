package com.sangeng.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Date;

@Controller
public class ConverterController  {



    @RequestMapping("/testConverter")
    public String tesstConverter(Boolean success){
        System.out.println("tesstConverter");
        System.out.println(success);
        return "/success.jsp";
    }

    @RequestMapping("/testDateConverter")
    public String testDateConverter(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday){
        System.out.println("testDateConverter");
        System.out.println(birthday);
        return "/success.jsp";
    }
}
