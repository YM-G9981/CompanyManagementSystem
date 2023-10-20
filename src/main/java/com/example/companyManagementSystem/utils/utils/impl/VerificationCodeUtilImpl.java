package com.example.companyManagementSystem.utils.utils.impl;

import com.example.companyManagementSystem.utils.utils.VerificationCodeUtil;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Configuration
public class VerificationCodeUtilImpl implements VerificationCodeUtil {
    @Resource
    private HttpServletRequest request;

    @Override
    public String generateVerificationCode(String key) {
        Random random = new Random();
        String code = String.valueOf(random.nextInt(1000000));
        request.getSession().setAttribute(key, code);
        return code;
    }

    @Override
    public boolean checkVerificationCode(String key, String value) {
        Object attribute = request.getSession().getAttribute(key);
        if (key != null && attribute instanceof String) {
            return attribute.equals(value);
        } else {
            return false;
        }
    }
}
