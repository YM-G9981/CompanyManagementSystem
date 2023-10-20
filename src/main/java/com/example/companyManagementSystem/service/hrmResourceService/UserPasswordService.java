package com.example.companyManagementSystem.service.hrmResourceService;

public interface UserPasswordService {
    boolean modifyPassword(String username, String oldPassword, String newPassword);

    boolean forgetPassword(String username, String emailAddress, String key);

    boolean modifyForgetPassword(String username, String verificationCode, String newPassword, String key);
}
