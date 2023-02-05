package com.sangeng.dao;

import com.sangeng.pojo.Order;

import java.util.List;

public interface OrderDao {

//    查询所有订单
    List<Order> findAll();

    //根据订单id查询订单，要求把下单用户的信息也查询出来
    Order findById(Integer id);


}
