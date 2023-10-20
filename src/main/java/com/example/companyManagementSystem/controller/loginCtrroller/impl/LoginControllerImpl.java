package com.example.companyManagementSystem.controller.loginCtrroller.impl;

import com.example.companyManagementSystem.controller.loginCtrroller.LoginController;
import com.example.companyManagementSystem.service.loginService.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginControllerImpl implements LoginController {
    @Resource
    private LoginService loginService;
    @PostMapping("/login")
    @Override
    public boolean login(String username,String password) {
        return loginService.login(username,password);
    }
}
