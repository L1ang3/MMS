package com.mms.demo.service.impl;

import com.mms.demo.mapper.UserMapper;
import com.mms.demo.model.User;
import com.mms.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean login(String name, String passwd){
        User user = userMapper.findUserByName(name);
        return user != null && user.getPasswd().equals(passwd);
    }
}
