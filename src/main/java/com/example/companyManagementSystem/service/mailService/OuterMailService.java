package com.example.companyManagementSystem.service.mailService;

import com.example.companyManagementSystem.entity.mail.outerMail.Mail;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface OuterMailService {
    boolean saveMail(Mail mail);

    boolean sendMail(Mail mail);

    boolean modifyMail(Mail mail);

    boolean saveAppendixFiles(Mail mail);

    List<Mail> getMailsBySender(long senderId);

    List<Mail> getMailsLikeSubject(String subject, long senderId);

    List<Mail> getMailsLikeSendTo(String sendTo, long senderId);

    List<Mail> getMailByMailIds(List<Long> mailIds, long senderId);

    List<Mail> getMailsBySendTimeBetween(Date minDate, Date maxDate, long senderId);

    boolean delAppendixFile(long appendixFileId);

    boolean delMail(List<Long> mailIds);

    boolean dropAppendixFiles(List<Long> mailIds);

    List<Mail> getAllMails();

    ResponseEntity<byte[]> getFile(long fileId);
}
