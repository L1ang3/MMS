package com.mms.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mms.demo.comm.Result;
import com.mms.demo.service.LoginService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Resource
    private LoginService loginService;
    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestParam("username") String loginName,
                        @RequestParam("hashedPassword") String password,
                        HttpSession httpSession) {
        if(loginService.login(loginName,password)){
            return Result.ok(null);
        }
        else{
            return Result.err(null);
        }
    }
}
