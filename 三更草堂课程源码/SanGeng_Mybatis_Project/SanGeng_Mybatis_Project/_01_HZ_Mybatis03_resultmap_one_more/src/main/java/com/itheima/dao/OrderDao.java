package com.itheima.dao;

import com.itheima.domain.Order;
import org.apache.ibatis.annotations.Select;

public interface OrderDao {
    Order selectById(Integer id);

}
