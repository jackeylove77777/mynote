package com.itheima.dao;

import com.itheima.domain.Order;

import java.util.List;

public interface OrderDao2 {

    Order selectById(Integer id);

    /**
     * 更加userid查询该用户的所有订单
     * @param uid
     * @return
     */
    List<Order> selectByUid(Integer uid);
}
