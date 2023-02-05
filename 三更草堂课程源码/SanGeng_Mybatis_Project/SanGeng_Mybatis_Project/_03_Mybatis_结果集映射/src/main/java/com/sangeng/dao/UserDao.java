package com.sangeng.dao;

import com.sangeng.pojo.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    //根据id查询用户，并且要求把该用户所具有的角色信息也查询出来
    User findById(Integer id);


    //根据用户名查询用户，并且要求把该用户所具有的角色信息也查询出来
    User findByUsername(String username);
}
