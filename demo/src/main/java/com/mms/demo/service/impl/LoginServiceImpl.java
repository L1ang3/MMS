package com.mms.demo.service.impl;

import com.mms.demo.comm.Result;
import com.mms.demo.mapper.UserMapper;
import com.mms.demo.model.User;
import com.mms.demo.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean login(String name, String passwd, HttpSession session){
        User user = userMapper.findUserByName(name);
        boolean res = user != null && user.getPasswd().equals(passwd);
        if(res){
            session.setAttribute("user",user);
            session.setAttribute("name",user.getName());
            session.setAttribute("id",user.getId());
        }
        return res;
    }

    @Override
    public Result register(User user){
        if(userMapper.isNameExisted(user.getName())==0){
            userMapper.insertUser(user);
        }else{
            return Result.err("name exists");
        }
        return Result.ok(null);
    }
}
