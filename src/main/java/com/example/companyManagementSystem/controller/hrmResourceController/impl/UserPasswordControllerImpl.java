package com.example.companyManagementSystem.controller.hrmResourceController.impl;

import com.example.companyManagementSystem.controller.hrmResourceController.UserPasswordController;
import com.example.companyManagementSystem.service.hrmResourceService.UserPasswordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userPassword")
public class UserPasswordControllerImpl implements UserPasswordController {
    @Resource
    private UserPasswordService service;

    @PostMapping("/modifyPassword")
    @Override
    public boolean modifyPassword(@RequestBody String username, @RequestBody String oldPassword, @RequestBody String newPassword) {
        return service.modifyPassword(username, oldPassword, newPassword);
    }

    @PostMapping("/forgetPassword")
    @Override
    public boolean forgetPassword(@RequestBody String username, @RequestBody String emailAddress, @RequestBody String key) {
        return service.forgetPassword(username, emailAddress, key);
    }

    @PostMapping("/modifyForgetPassword")
    @Override
    public boolean modifyForgetPassword(@RequestBody String username, @RequestBody String verificationCode, @RequestBody String newPassword, @RequestBody String key) {
        return service.modifyForgetPassword(username, verificationCode, newPassword, key);
    }
}
