package com.example.companyManagementSystem.utils.utils;

public interface VerificationCodeUtil {
    String generateVerificationCode(String key);

    boolean checkVerificationCode(String key, String value);
}
