package com.example.companyManagementSystem.controller.mailController.impl;

import com.example.companyManagementSystem.controller.mailController.OuterMailController;
import com.example.companyManagementSystem.entity.mail.outerMail.Mail;
import com.example.companyManagementSystem.service.mailService.OuterMailService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/outerMail")
public class OuterMailControllerImpl implements OuterMailController {
    @Resource
    private OuterMailService outerMailService;

    @PostMapping("/saveMail")
    @Override
    public boolean saveMail(@RequestBody Mail mail) {
        return outerMailService.saveMail(mail);
    }

    @PostMapping("/sendMail")
    @Override
    public boolean sendMail(@RequestBody Mail mail) {
        return outerMailService.sendMail(mail);
    }

    @PostMapping("/modifyMail")
    @Override
    public boolean modifyMail(@RequestBody Mail mail) {
        return outerMailService.modifyMail(mail);
    }

    @PostMapping("/getMailsBySender/{senderId}")
    @Override
    public List<Mail> getMailsBySender(@PathVariable long senderId) {
        return outerMailService.getMailsBySender(senderId);
    }

    @PostMapping("/getMailsLikeSubject/{senderId}")
    @Override
    public List<Mail> getMailsLikeSubject(@RequestBody String subject,@PathVariable long senderId) {
        return outerMailService.getMailsLikeSubject(subject, senderId);
    }

    @PostMapping("/getMailsLikeSendTo/{senderId}")
    @Override
    public List<Mail> getMailsLikeSendTo(@RequestBody String sendTo,@PathVariable long senderId) {
        return outerMailService.getMailsLikeSendTo(sendTo, senderId);
    }

    @PostMapping("/getMailByMailIds/{senderId}")
    @Override
    public List<Mail> getMailByMailIds(@RequestBody List<Long> mailIds,@PathVariable long senderId) {
        return outerMailService.getMailByMailIds(mailIds, senderId);
    }

    @Override
    @PostMapping("/getMailsBySendTimeBetween/{minDate}/{maxDate}/{senderId}")
    public List<Mail> getMailsBySendTimeBetween(@PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") Date minDate, @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") Date maxDate,@PathVariable long senderId) {
        return outerMailService.getMailsBySendTimeBetween(minDate, maxDate, senderId);
    }

    @Override
    @PostMapping("/delAppendixFile/{appendixFileId}")
    public boolean delAppendixFile(@PathVariable long appendixFileId) {
        return outerMailService.delAppendixFile(appendixFileId);
    }

    @Override
    @PostMapping("/getFile/{fileId}")
    public ResponseEntity<byte[]> getFile(@PathVariable long fileId) {
        return outerMailService.getFile(fileId);
    }

    @Override
    @PostMapping("/delMail")
    public boolean delMail(@RequestBody List<Long> mailIds) {
        return outerMailService.delMail(mailIds);
    }

    @Override
    @PostMapping("/getAllMails")
    public List<Mail> getAllMails() {
        return outerMailService.getAllMails();
    }
}
