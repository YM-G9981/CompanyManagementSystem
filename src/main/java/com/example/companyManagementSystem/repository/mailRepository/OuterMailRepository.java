package com.example.companyManagementSystem.repository.mailRepository;

import com.example.companyManagementSystem.entity.mail.outerMail.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OuterMailRepository extends JpaRepository<Mail, Long> {
    List<Mail> findAllByUserUserId(long userId);

    List<Mail> findAllBySubjectLikeAndUser_UserId(String subject,long userId);

    List<Mail> findAllBySendToAndUser_UserId(String sendTo,long userId);

    List<Mail> findAllByMailIdInAndUser_UserId(List<Long> mailIds,long userId);

    List<Mail> findAllBySendTimeBetweenAndUser_UserId(Date minDate, Date maxDate,long userId);

}
