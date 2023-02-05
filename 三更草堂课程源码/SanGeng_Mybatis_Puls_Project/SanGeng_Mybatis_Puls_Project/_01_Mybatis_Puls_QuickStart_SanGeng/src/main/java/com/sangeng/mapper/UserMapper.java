package com.sangeng.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.sangeng.domian.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface UserMapper extends BaseMapper<User> {

    User findMyUser(Long id);

    User findMyUserByWrapper(@Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
