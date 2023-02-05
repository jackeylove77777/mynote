package com.sangeng.mapper;

import com.sangeng.domain.SystemUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SystemUserMapper {
    SystemUser login(SystemUser user);
}
