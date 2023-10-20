package com.example.companyManagementSystem.service.mailService.impl;

import com.example.companyManagementSystem.entity.mail.outerMail.AppendixFile;
import com.example.companyManagementSystem.entity.mail.outerMail.Mail;
import com.example.companyManagementSystem.repository.mailRepository.OuterMailAppendixFileRepository;
import com.example.companyManagementSystem.repository.mailRepository.OuterMailRepository;
import com.example.companyManagementSystem.service.mailService.OuterMailService;
import com.example.companyManagementSystem.utils.utils.FileUtil;
import com.example.companyManagementSystem.utils.utils.OuterMailUtil;
import com.example.companyManagementSystem.utils.utils.RepositoryUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class OuterMailServiceImpl implements OuterMailService {
    @Resource
    private OuterMailRepository outerMailRepository;
    @Resource
    private OuterMailAppendixFileRepository outerMailAppendixFileRepository;
    @Resource
    private OuterMailUtil outerMailUtil;
    @Resource
    private FileUtil fileUtil;
    @Resource
    private RepositoryUtil repositoryUtil;
    @Value("${filePath.outerMailFile}")
    private String filePath;

    @Override
    public boolean saveMail(Mail mail) {
        mail.setMailState(2);
        return repositoryUtil.save(outerMailRepository, mail);
    }

    @Override
    public boolean sendMail(Mail mail) {
        mail.setMailState(1);
        return outerMailUtil.sendMail(mail) && saveMail(mail);
    }

    @Override
    public boolean modifyMail(Mail mail) {
        return mail.getMailState() == 0 && saveMail(mail);
    }

    @Override
    public boolean saveAppendixFiles(Mail mail) {
        List<AppendixFile> appendixFiles = mail.getAppendixFiles();
        try {
            for (int i = 0; i < appendixFiles.size(); i++) {
                AppendixFile file = appendixFiles.get(i);
                if (file.getFileId() != 0) {
                    continue;
                }
                File mailFile = fileUtil.saveFile(file.getFile(), filePath, mail.getMailId() + "_" + System.currentTimeMillis() + "_" + file.getFile().getName());
                if (mailFile != null) {
                    file.setFile(mailFile);
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
    public List<Mail> getMailsBySender(long senderId) {
        return outerMailRepository.findAllByUserUserId(senderId);
    }

    @Override
    public List<Mail> getMailsLikeSubject(String subject, long senderId) {
        return outerMailRepository.findAllBySubjectLikeAndUser_UserId(subject,senderId );
    }

    @Override
    public List<Mail> getMailsLikeSendTo(String sendTo, long senderId) {
        return outerMailRepository.findAllBySendToAndUser_UserId(sendTo,senderId );
    }

    @Override
    public List<Mail> getMailByMailIds(List<Long> mailIds, long senderId) {
        return outerMailRepository.findAllByMailIdInAndUser_UserId(mailIds, senderId);
    }

    @Override
    public List<Mail> getMailsBySendTimeBetween(Date minDate, Date maxDate, long senderId) {
        return outerMailRepository.findAllBySendTimeBetweenAndUser_UserId(minDate, maxDate, senderId);
    }

    @Override
    public boolean delAppendixFile(long appendixFileId) {
        AppendixFile appendixFile = outerMailAppendixFileRepository.findAppendixFileByFileId(appendixFileId);
        outerMailAppendixFileRepository.delete(appendixFile);
        return fileUtil.delFile(appendixFile.getFile());
    }

    @Override
    public boolean delMail(List<Long> mailIds) {
        if (!dropAppendixFiles(mailIds)) {
            return false;
        }
        try {
            outerMailRepository.deleteAllById(mailIds);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean dropAppendixFiles(List<Long> mailIds) {
        List<AppendixFile> appendixFiles = outerMailAppendixFileRepository.findAppendixFileByMailId(mailIds);
        for (AppendixFile appendixFile : appendixFiles) {
            if (!repositoryUtil.delete(outerMailAppendixFileRepository, appendixFile) || !fileUtil.delFile(appendixFile.getFile())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Mail> getAllMails() {
        return outerMailRepository.findAll();
    }

    @Override
    public ResponseEntity<byte[]> getFile(long fileId) {
        File file = outerMailAppendixFileRepository.findAppendixFileByFileId(fileId).getFile();
        return fileUtil.getResponseEntity(file);
    }

}
