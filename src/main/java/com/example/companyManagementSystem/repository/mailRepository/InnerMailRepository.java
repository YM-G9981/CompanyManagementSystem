package com.example.companyManagementSystem.repository.mailRepository;

import com.example.companyManagementSystem.entity.mail.innerMail.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface InnerMailRepository extends JpaRepository<Mail, Long> {
    List<Mail> findMailByMailId(long mailId);

    List<Mail> findMailByAddresser_UserIdAndMailState(long userId, int state);

    List<Mail> findMailByAddressee_UserIdAndMailState(long userId, int state);

    @Modifying
    @Transactional
    @Query(value = "update inner_mails m set mail_state = 3 where mail_id in ?1", nativeQuery = true)
    int delMails(List<Long> mailIds);

    List<Mail> findMailBySendTimeBetween(Date minDate, Date maxDate);

    List<Mail> findMailByAddresser_UserIdAndMailStateAndAddressee_UserIdAndMailTitleLike(long addresserId, int mailState, long addresseeId, String mailTitle);

    List<Mail> findMailByAddresser_UserIdAndMailStateAndAddressee_UserIdAndMailContextLike(long addresserId, int mailState, long addresseeId, String state);

    List<Mail> findMailByAddresser_UserIdAndAddressee_UserIdAndMailState(long addresserId, long addresseeId, int state);

    @Modifying
    @Transactional
    @Query(value = "update inner_mails m set mail_state = 2 where mail_id in ?1", nativeQuery = true)
    int readMail(List<Long> mailIds);
}
