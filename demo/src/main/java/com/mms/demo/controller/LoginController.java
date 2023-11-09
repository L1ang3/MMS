package com.mms.demo.controller;

import com.mms.demo.comm.Result;
import com.mms.demo.model.User;
import com.mms.demo.service.LoginService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestParam("username") String name,
                            @RequestParam("hashedPassword") String password,
                           @RequestParam("email") String email,
                           @RequestParam("address") String address,
                           @RequestParam("phone") String phone) {
        User user=new User(name,password,email,address,phone,false);
        return loginService.register(user);
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }
}
