package com.sangeng.controller;

import com.github.pagehelper.PageInfo;
import com.sangeng.common.PageResult;
import com.sangeng.common.ResponseResult;
import com.sangeng.domain.User;
import com.sangeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseResult findById(@PathVariable("id") Integer id){
        User user = userService.findById(id);
        if(user==null){
            //说明没有对应的用户
            return new ResponseResult(500,"没有该用户");
        }
        return new ResponseResult(200,"操作成功",user);
    }
    @GetMapping("/user")
    public ResponseResult findAll(){
        System.out.println(1/0);
        List<User> list = userService.findAll();
        return new ResponseResult(200,"操作成功",list);
    }

    @GetMapping("/user/{pageSize}/{pageNum}")
    public ResponseResult findByPage(@PathVariable("pageSize") Integer pageSize,@PathVariable("pageNum") Integer pageNum){
        PageResult pageResult =  userService.findByPage(pageSize,pageNum);
        return new ResponseResult(200,"操作成功",pageResult);
    }

    @PostMapping("/user")
    public ResponseResult insertUser(@RequestBody User user){
        userService.insertUser(user);
        return new ResponseResult(200,"操作成功");
    }

    @DeleteMapping("/user/{id}")
    public ResponseResult deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return new ResponseResult(200,"操作成功");
    }

    @PutMapping("/user")
    public ResponseResult updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseResult(200,"操作成功");
    }


    @RequestMapping("/user/test")
    public ResponseResult test(){
        userService.test();
        return new ResponseResult(200,"操作成功");
    }
}
