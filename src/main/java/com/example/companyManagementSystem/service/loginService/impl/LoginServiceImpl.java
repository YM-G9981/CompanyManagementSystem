package com.example.companyManagementSystem.service.loginService.impl;

import com.example.companyManagementSystem.entity.hrmResource.User;
import com.example.companyManagementSystem.repository.hrmResourceRepository.UserRepository;
import com.example.companyManagementSystem.service.loginService.LoginService;
import com.example.companyManagementSystem.utils.utils.PasswordUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private PasswordUtil passwordUtil;
    @Override
    public boolean login(@RequestBody String username,@RequestBody String password) {
        User user = userRepository.findUserByUsername(username);
        return passwordUtil.checkPassword(password,user);
    }
}
