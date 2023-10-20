package com.example.companyManagementSystem.service.mailService.impl;

import com.example.companyManagementSystem.entity.mail.innerMail.AppendixFile;
import com.example.companyManagementSystem.entity.mail.innerMail.Mail;
import com.example.companyManagementSystem.repository.mailRepository.InnerMailAppendixFileRepository;
import com.example.companyManagementSystem.repository.mailRepository.InnerMailRepository;
import com.example.companyManagementSystem.service.mailService.InnerMailService;
import com.example.companyManagementSystem.utils.utils.FileUtil;
import com.example.companyManagementSystem.utils.utils.RepositoryUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class InnerMailServiceImpl implements InnerMailService {
    @Resource
    private InnerMailRepository innerMailRepository;
    @Resource
    private InnerMailAppendixFileRepository innerMailAppendixFileRepository;
    @Resource
    private RepositoryUtil repositoryUtil;
    @Value("${filePath.innerMailFile}")
    private String filePath;
    @Resource
    private FileUtil fileUtil;

    @Override
    public boolean sendMail(Mail mail) {
        mail.setMailState(1);
        return saveMail(mail);
    }

    @Override
    public boolean saveMail(Mail mail) {
        return repositoryUtil.save(innerMailRepository, mail) &&
                saveMailFile(mail) &&
                repositoryUtil.saveAll(innerMailAppendixFileRepository, mail.getAppendixFiles());
    }

    @Override
    public boolean modifyMail(Mail mail) {
        if (mail.getMailState() != 0) {
            return false;
        }
        return saveMail(mail);
    }

    @Override
    public List<Mail> getMailsByMailId(Long mailId) {
        return innerMailRepository.findMailByMailId(mailId);
    }

    @Override
    public List<Mail> getMailsByAddresser(long addresserId, int state) {
        return innerMailRepository.findMailByAddresser_UserIdAndMailState(addresserId, state);
    }

    @Override
    public List<Mail> getMailsByAddressee(long addresseeId, int state) {
        return innerMailRepository.findMailByAddressee_UserIdAndMailState(addresseeId, state);
    }

    @Override
    public boolean delMails(List<Long> mailIds) {
        return innerMailRepository.delMails(mailIds) != -1;
    }

    @Override
    public boolean dropMails(List<Long> mailIds) {
        return !dropAppendixFiles(mailIds) && repositoryUtil.deleteAllById(innerMailRepository, mailIds);
    }

    @Override
    public boolean dropAppendixFiles(List<Long> mailIds) {
        List<AppendixFile> appendixFiles = innerMailAppendixFileRepository.findAppendixFileByMailId(mailIds);
        try {
            for (AppendixFile appendixFile : appendixFiles) {
                File file = appendixFile.getFile();
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Mail> getMailsByMailTitleLike(long userId, String mailTitle, int state) {
        return innerMailRepository.findMailByAddresser_UserIdAndMailStateAndAddressee_UserIdAndMailTitleLike(userId, state, userId, mailTitle);
    }

    @Override
    public List<Mail> getMailsByMailSummaryLike(long userId, String mailSummary, int state) {
        return innerMailRepository.findMailByAddresser_UserIdAndMailStateAndAddressee_UserIdAndMailContextLike(userId, state, userId, mailSummary);
    }

    @Override
    public List<Mail> getTrashMailsByUser(long userId) {
        return innerMailRepository.findMailByAddresser_UserIdAndAddressee_UserIdAndMailState(userId, userId, 3);
    }

    @Override
    public boolean readMails(List<Long> mailIds) {
        return innerMailRepository.readMail(mailIds) > 1;
    }

    @Override
    public boolean saveMailFile(Mail mail) {
        List<AppendixFile> files = mail.getAppendixFiles();
        try {
            for (int i = 0; i < files.size(); i++) {
                AppendixFile file = files.get(i);
                if (file.getFileId() != 0) {
                    continue;
                }
                File mailFile = fileUtil.saveFile(file.getFile(), filePath, mail.getMailId() + "_" + System.currentTimeMillis() + "_" + file.getFile().getName());
                if (mailFile != null) {
                    file.setFile(mailFile);
                    file.setMail(mail);
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Mail> getMailsBySendTimeBetween(Date minDate, Date maxDate) {
        return innerMailRepository.findMailBySendTimeBetween(minDate, maxDate);
    }

    @Override
    public boolean delAppendixFile(long appendixFileId) {
        AppendixFile appendixFile = innerMailAppendixFileRepository.findAppendixFileByFileId(appendixFileId);
        return fileUtil.delFile(appendixFile.getFile()) && repositoryUtil.delete(innerMailAppendixFileRepository, appendixFile);
    }

    @Override
    public ResponseEntity<byte[]> getFile(long fileId) {
        File file = innerMailAppendixFileRepository.findAppendixFileByFileId(fileId).getFile();
        return fileUtil.getResponseEntity(file);
    }

    @Override
    public List<Mail> getAllMails() {
        return innerMailRepository.findAll();
    }
}
