package com.example.companyManagementSystem.utils.utils.impl;

import com.example.companyManagementSystem.entity.hrmResource.User;
import com.example.companyManagementSystem.utils.utils.PasswordUtil;
import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;


@Configuration
public class PasswordUtilImpl implements PasswordUtil {
    @Override
    public void encode(User user) {
        String password = user.getPassword();
        user.setPassword(string2MD5(password));
    }
    //密码对比方法
    @Override
    public boolean checkPassword(String password, User user) {
        password = string2MD5(password);
        return user!=null&&password.equals(user.getPassword());
    }
    //Md5密码加密方法
    @Override
    public String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++){
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString().toUpperCase();
    }
}
