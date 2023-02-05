package com.sangeng.dao;

import com.sangeng.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> findAll();
    User findById(Integer id);

    User findByUser(User user);
    User findByMap(Map map);

    List<User> findByCondition(@Param("id") Integer id,@Param("username") String username);

//    新增数据
    void insertUser(User user);

//    删除数据
    void deleteById(Integer id);

//    修改数据
    void updateUser(User user);

    List<User> findByIds(@Param("ids") Integer[] ids);


    List<User> selectChose(User user);
}
