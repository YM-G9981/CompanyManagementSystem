package com.example.companyManagementSystem.service.hrmResourceService;

import com.example.companyManagementSystem.entity.hrmResource.User;

public interface ResignUserService {
    boolean resignFromPersonal(User resignUser, String key, String verificationCode);

    boolean resignFromAdministrator(User resignUser);

    boolean sendResignEmail(String emailAddress, String username, String key);

    boolean checkUsernameUnique(String username);
}
