package com.mms.demo.service;

import jakarta.servlet.http.HttpSession;

public interface LoginService {
    public boolean login(String name, String passwd, HttpSession session);
}
