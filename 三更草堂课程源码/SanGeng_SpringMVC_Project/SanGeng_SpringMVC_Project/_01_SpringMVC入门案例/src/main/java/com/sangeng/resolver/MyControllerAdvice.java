package com.sangeng.resolver;

import com.sangeng.pojo.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Component
public class MyControllerAdvice {

//    @ExceptionHandler({NullPointerException.class,ArithmeticException.class})
//    public ModelAndView handlerException(Exception ex){
//        //如果出现了相关的异常，就会调用该方法
//        String msg = ex.getMessage();
//        ModelAndView modelAndView = new ModelAndView();
//        //把异常信息存入域中
//        modelAndView.addObject("msg",msg);
//        //跳转到error.jsp
//        modelAndView.setViewName("/WEB-INF/page/error.jsp");
//        return modelAndView;
//    }

    @ExceptionHandler({NullPointerException.class,ArithmeticException.class})
    @ResponseBody
    public Result handlerException(Exception ex){
        Result result = new Result();
        result.setMsg(ex.getMessage());
        result.setCode(500);
        return result;
    }
}
