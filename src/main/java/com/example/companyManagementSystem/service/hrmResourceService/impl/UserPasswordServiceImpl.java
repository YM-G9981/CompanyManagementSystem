package com.example.companyManagementSystem.service.hrmResourceService.impl;

import com.example.companyManagementSystem.entity.hrmResource.User;
import com.example.companyManagementSystem.repository.hrmResourceRepository.UserRepository;
import com.example.companyManagementSystem.service.hrmResourceService.UserPasswordService;
import com.example.companyManagementSystem.utils.utils.OuterMailUtil;
import com.example.companyManagementSystem.utils.utils.PasswordUtil;
import com.example.companyManagementSystem.utils.utils.RepositoryUtil;
import com.example.companyManagementSystem.utils.utils.VerificationCodeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserPasswordServiceImpl implements UserPasswordService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private OuterMailUtil outerMailUtil;
    @Resource
    private PasswordUtil passwordUtil;
    @Resource
    private VerificationCodeUtil verificationCodeUtil;
    @Resource
    private RepositoryUtil repositoryUtil;

    @Override
    public boolean modifyPassword(String username, String oldPassword, String newPassword) {
        User user = userRepository.findUserByUsername(username);
        if (!passwordUtil.checkPassword(oldPassword, user)) {
            return false;
        }
        user.setPassword(newPassword);
        passwordUtil.encode(user);
        return true;
    }

    @Override
    public boolean forgetPassword(String username, String emailAddress, String key) {
        String verificationCode = verificationCodeUtil.generateVerificationCode(key);
        return outerMailUtil.sendEmail(emailAddress, username, verificationCode, "变更密码验证码");
    }

    @Override
    public boolean modifyForgetPassword(String username, String verificationCode, String newPassword, String key) {
        if (verificationCodeUtil.checkVerificationCode(key, verificationCode)) {
            User user = userRepository.findUserByUsername(username);
            user.setPassword(newPassword);
            passwordUtil.encode(user);
            return repositoryUtil.save(userRepository,user);
        } else {
            return false;
        }
    }
}
