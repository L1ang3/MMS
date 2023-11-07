package com.mms.demo.service;

import com.mms.demo.comm.Result;
import com.mms.demo.model.User;
import jakarta.servlet.http.HttpSession;

public interface LoginService {
    public boolean login(String name, String passwd, HttpSession session);
    public Result register(User user);
}
