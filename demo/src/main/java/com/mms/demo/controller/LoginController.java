package com.mms.demo.controller;

import com.mms.demo.comm.Result;
import com.mms.demo.service.LoginService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {
    @Resource
    private LoginService loginService;
    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestParam("username") String loginName,
                        @RequestParam("hashedPassword") String password,
                        HttpSession session) {
        if(loginService.login(loginName,password,session)){
            return Result.ok(null);
        }
        else{
            return Result.err(null);
        }
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "redirect:/assert/html/welcome.html";
    }
}
