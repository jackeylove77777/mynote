package com.sangeng.mapper;

import com.sangeng.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserMapper {

    public List<User> findAll();
}
