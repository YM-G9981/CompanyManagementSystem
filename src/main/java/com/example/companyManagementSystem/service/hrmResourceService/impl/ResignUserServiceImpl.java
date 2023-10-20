package com.example.companyManagementSystem.service.hrmResourceService.impl;

import com.example.companyManagementSystem.entity.hrmResource.User;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PersonalRepository;
import com.example.companyManagementSystem.repository.hrmResourceRepository.UserRepository;
import com.example.companyManagementSystem.service.hrmResourceService.ResignUserService;
import com.example.companyManagementSystem.utils.utils.OuterMailUtil;
import com.example.companyManagementSystem.utils.utils.PasswordUtil;
import com.example.companyManagementSystem.utils.utils.RepositoryUtil;
import com.example.companyManagementSystem.utils.utils.VerificationCodeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResignUserServiceImpl implements ResignUserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private OuterMailUtil outerMailUtil;
    @Resource
    private VerificationCodeUtil verificationCodeUtil;
    @Resource
    private PasswordUtil passwordUtil;
    @Resource
    private RepositoryUtil repositoryUtil;
    @Resource
    private PersonalRepository personalRepository;
    @Override
    public boolean resignFromPersonal(User resignUser, String key, String verificationCode) {
        passwordUtil.encode(resignUser);
        return verificationCodeUtil.checkVerificationCode(key, verificationCode) && repositoryUtil.save(userRepository, resignUser);
    }

    @Override
    public boolean resignFromAdministrator(User resignUser) {
        passwordUtil.encode(resignUser);
        return repositoryUtil.save(userRepository, resignUser);
    }

    @Override
    public boolean sendResignEmail(String emailAddress, String username, String key) {
        String verificationCode = verificationCodeUtil.generateVerificationCode(key);
        return outerMailUtil.sendEmail(emailAddress, key, verificationCode, "账户注册验证码通知");
    }

    @Override
    public boolean checkUsernameUnique(String username) {
        return userRepository.existsUserByUsernameLike(username);
    }

}
