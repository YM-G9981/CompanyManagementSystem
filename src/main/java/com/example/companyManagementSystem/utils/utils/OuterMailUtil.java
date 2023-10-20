package com.example.companyManagementSystem.utils.utils;

import com.example.companyManagementSystem.entity.mail.outerMail.Mail;

public interface OuterMailUtil {
    boolean sendEmail(String emailAddress, String username, String verificationCode, String title);

    boolean sendMail(Mail mail);
}
