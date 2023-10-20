package com.example.companyManagementSystem;


import com.example.companyManagementSystem.controller.mailController.InnerMailController;
import com.example.companyManagementSystem.entity.hrmResource.User;
import com.example.companyManagementSystem.entity.mail.innerMail.Mail;
import com.example.companyManagementSystem.repository.hrmResourceRepository.UserRepository;
import com.example.companyManagementSystem.repository.mailRepository.InnerMailRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class CompanyManagementSystemApplicationTests {
    @Resource
    private InnerMailController innerMailController;
    @Test
    void test() {
        List<Mail> mails=  innerMailController.getMailsByAddressee(3l, 1);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(2451545+737998-0.5);
    }
}