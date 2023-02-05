package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.User;
import com.sangeng.resolver.CurrentUserId;
import com.sangeng.service.UserServcie;
import com.sangeng.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
//@CrossOrigin
public class UserController {

    @Autowired
    private UserServcie userServcie;

    @RequestMapping("/insertUser")
    public ResponseResult insertUser(){
        userServcie.insertUser();
        return new ResponseResult(200,"添加成功");
    }


    @RequestMapping("/findAll")
    public ResponseResult findAll(@CurrentUserId String userId) throws Exception {
        //获取请求头中的token
//        String token = request.getHeader("token");
//        if(StringUtils.hasText(token)){
//            //解析token获取用户id
//            Claims claims = JwtUtil.parseJWT(token);
//            String userId = claims.getSubject();
//            System.out.println(userId);
//        }
        System.out.println(userId);
        //调用service查询数据 ，进行返回s
        List<User> users = userServcie.findAll();
        return new ResponseResult(200,users);
    }
}