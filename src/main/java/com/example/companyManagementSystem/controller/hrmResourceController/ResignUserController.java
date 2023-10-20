package com.example.companyManagementSystem.controller.hrmResourceController;

import com.example.companyManagementSystem.entity.hrmResource.User;

public interface ResignUserController {
    boolean resignFromPersonal(User resignUser, String key, String verificationCode);

    boolean resignFromAdministrator(User resignUser);

    boolean sendResignEmail(String emailAddress, String username, String key);

    boolean checkUsernameUnique(String username);

}
