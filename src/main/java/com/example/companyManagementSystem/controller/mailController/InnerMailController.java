package com.example.companyManagementSystem.controller.mailController;

import com.example.companyManagementSystem.entity.mail.innerMail.Mail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

public interface InnerMailController {
    boolean sendMail(Mail mail);

    boolean saveMail(Mail mail);

    boolean modifyMail(Mail mail);

    List<Mail> getMailsByMailId(long MailId);

    List<Mail> getMailsByAddresser(long addresserId, int state);

    List<Mail> getMailsByAddressee(long addresseeId, int state);

    List<Mail> getMailsBySendTimeBetween(Date minDate, Date maxDate);

    boolean delMails(List<Long> MailIds);

    boolean dropMails(List<Long> MailIds);

    List<Mail> getMailsByMailTitleLike(long userId, String MailTitle, int state);

    List<Mail> getMailsByMailSummaryLike(long userId, String MailTitle, int state);

    List<Mail> getTrashMailByUser(long userId);

    boolean readMails(List<Long> mailIds);

    boolean delAppendixFile(long appendixFileId);

    ResponseEntity<byte[]> getFile(long fileId);

    @PostMapping("/getAllMail")
    List<Mail> getAllMails();
}
