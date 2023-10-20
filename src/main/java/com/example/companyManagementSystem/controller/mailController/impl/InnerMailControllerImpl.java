package com.example.companyManagementSystem.controller.mailController.impl;

import com.example.companyManagementSystem.controller.mailController.InnerMailController;
import com.example.companyManagementSystem.entity.mail.innerMail.Mail;
import com.example.companyManagementSystem.service.mailService.InnerMailService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/innerMail")
public class InnerMailControllerImpl implements InnerMailController {
    @Resource
    private InnerMailService innerMailService;

    @Override
    @PostMapping("/sendMail")
    public boolean sendMail(@RequestBody Mail mail) {
        return innerMailService.sendMail(mail);
    }

    @Override
    @PostMapping("/saveMail")
    public boolean saveMail(@RequestBody Mail mail) {
        return innerMailService.saveMail(mail);
    }

    @Override
    @PostMapping("/modifyMail")
    public boolean modifyMail(@RequestBody Mail mail) {
        return innerMailService.modifyMail(mail);
    }

    @Override
    @PostMapping("/getMailsByMailId/{mailId}")
    public List<Mail> getMailsByMailId(@PathVariable long mailId) {
        return innerMailService.getMailsByMailId(mailId);
    }

    @Override
    @PostMapping("/getMailsByAddresser/{addresserId}/{state}")
    public List<Mail> getMailsByAddresser(@PathVariable long addresserId, @PathVariable int state) {
        return innerMailService.getMailsByAddresser(addresserId, state);
    }

    @Override
    @PostMapping("/getMailsByAddressee/{addresseeId}/{state}")
    public List<Mail> getMailsByAddressee(@PathVariable long addresseeId, @PathVariable int state) {
        return innerMailService.getMailsByAddressee(addresseeId, state);
    }

    @Override
    @PostMapping("/getMailsBySendTimeBetween/{minDate}/{maxDate}")
    public List<Mail> getMailsBySendTimeBetween(@PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") Date minDate, @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") Date maxDate) {
        return innerMailService.getMailsBySendTimeBetween(minDate, maxDate);
    }

    @Override
    @PostMapping("/delMails")
    public boolean delMails(@RequestBody List<Long> mailIds) {
        return innerMailService.delMails(mailIds);
    }

    @Override
    @PostMapping("/dropMails")
    public boolean dropMails(@RequestBody List<Long> mailIds) {
        return innerMailService.dropMails(mailIds);
    }


    @Override
    @PostMapping("/getMailsByMailTitleLike/{userId}/{mailTitle}/{state}")
    public List<Mail> getMailsByMailTitleLike(@PathVariable long userId, @PathVariable String mailTitle, @PathVariable int state) {
        return innerMailService.getMailsByMailTitleLike(userId, mailTitle, state);
    }

    @Override
    @PostMapping("/getMailsByMailSummaryLike/{userId}/{mailTitle}/{state}")
    public List<Mail> getMailsByMailSummaryLike(@PathVariable long userId, @PathVariable String mailTitle, @PathVariable int state) {
        return innerMailService.getMailsByMailSummaryLike(userId, mailTitle, state);
    }

    @Override
    @PostMapping("/getTrashMailByUser/{userId}")
    public List<Mail> getTrashMailByUser(@PathVariable long userId) {
        return innerMailService.getTrashMailsByUser(userId);
    }

    @Override
    @PostMapping("/readMails")
    public boolean readMails(@RequestBody List<Long> mailIds) {
        return innerMailService.readMails(mailIds);
    }

    @Override
    @PostMapping("/delAppendixFile/{appendixFileId}")
    public boolean delAppendixFile(@PathVariable long appendixFileId) {
        return innerMailService.delAppendixFile(appendixFileId);
    }
    @Override
    @PostMapping("/getFile/{fileId}")
    public ResponseEntity<byte[]> getFile(@PathVariable long fileId){
        return innerMailService.getFile(fileId);
    }

    @Override
    @PostMapping("/getAllMails")
    public List<Mail> getAllMails(){
        return innerMailService.getAllMails();
    }
}
