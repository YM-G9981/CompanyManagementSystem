package com.example.companyManagementSystem.utils.utils.impl;

import com.example.companyManagementSystem.entity.mail.outerMail.AppendixFile;
import com.example.companyManagementSystem.entity.mail.outerMail.Mail;
import com.example.companyManagementSystem.utils.utils.OuterMailUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Configuration
public class OuterMailUtilImpl implements OuterMailUtil {
    @Value("spring.mail.username")
    String sendFromEmailAddress;
    @Resource
    private JavaMailSender sender;

    @Override
    public boolean sendEmail(String emailAddress, String username, String verificationCode, String title) {

        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setTo(emailAddress);
            helper.setSubject(title);
            helper.setText("尊敬的用户" + username + "\n您的验证码为" + verificationCode + "\n" + "五分钟内有效");
            helper.setFrom(sendFromEmailAddress);
            sender.send(mimeMessage);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sendMail(Mail mail) {
        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setSubject(mail.getSubject());
            helper.setFrom(sendFromEmailAddress);
            helper.setText(mail.getText(), true);
            helper.setTo(mail.getSendTo());
            helper.setSentDate(mail.getSendTime());
            List<AppendixFile> appendixFiles = mail.getAppendixFiles();
            for (AppendixFile appendixFile : appendixFiles) {
                File file = appendixFile.getFile();
                helper.addAttachment(file.getName(), file.getAbsoluteFile());
            }
            sender.send(mimeMessage);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}