package com.mms.demo.mapper;

import com.mms.demo.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public User findUserByName(@Param("name")String name);
}
