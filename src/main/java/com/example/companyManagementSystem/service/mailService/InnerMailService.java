package com.example.companyManagementSystem.service.mailService;

import com.example.companyManagementSystem.entity.mail.innerMail.Mail;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface InnerMailService {
    boolean sendMail(Mail mail);

    boolean saveMail(Mail mail);

    boolean modifyMail(Mail mail);

    List<Mail> getMailsByMailId(Long MailId);

    List<Mail> getMailsByAddresser(long addresserId, int state);

    List<Mail> getMailsByAddressee(long addresseeId, int state);

    boolean delMails(List<Long> mailIds);

    boolean dropMails(List<Long> mailIds);

    boolean dropAppendixFiles(List<Long> mailIds);

    List<Mail> getMailsByMailTitleLike(long userId, String MailTitle, int state);

    List<Mail> getMailsByMailSummaryLike(long userId, String mailSummary, int state);

    List<Mail> getTrashMailsByUser(long userId);

    boolean readMails(List<Long> mailIds);

    boolean saveMailFile(Mail mail);

    List<Mail> getMailsBySendTimeBetween(Date minDate, Date maxDate);

    boolean delAppendixFile(long appendixFileId);

    ResponseEntity<byte[]> getFile(long fileId);

    List<Mail> getAllMails();
}
