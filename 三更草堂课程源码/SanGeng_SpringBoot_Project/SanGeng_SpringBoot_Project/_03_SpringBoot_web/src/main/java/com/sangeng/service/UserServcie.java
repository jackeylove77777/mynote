package com.sangeng.service;

import com.sangeng.domain.User;

import java.util.List;

public interface UserServcie {

    List<User> findAll();


    void insertUser();

}
