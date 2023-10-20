package com.example.companyManagementSystem.utils.utils;

import com.example.companyManagementSystem.entity.hrmResource.User;

public interface PasswordUtil {
    String string2MD5(String inStr);

    void encode(User user);

    boolean checkPassword(String password, User user);
}
