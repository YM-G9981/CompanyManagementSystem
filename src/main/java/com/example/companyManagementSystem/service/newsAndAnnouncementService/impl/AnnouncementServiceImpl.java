package com.example.companyManagementSystem.service.newsAndAnnouncementService.impl;

import com.example.companyManagementSystem.entity.newsAndAnnouncement.Announcement;
import com.example.companyManagementSystem.entity.newsAndAnnouncement.AnnouncementAppendixFile;
import com.example.companyManagementSystem.repository.newsAndAnnouncementRepository.AnnouncementAppendixFileRepository;
import com.example.companyManagementSystem.repository.newsAndAnnouncementRepository.AnnouncementRepository;
import com.example.companyManagementSystem.service.newsAndAnnouncementService.AnnouncementService;
import com.example.companyManagementSystem.utils.utils.FileUtil;
import com.example.companyManagementSystem.utils.utils.RepositoryUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    @Resource
    private AnnouncementRepository announcementRepository;
    @Resource
    private AnnouncementAppendixFileRepository announcementAppendixFileRepository;
    @Resource
    private RepositoryUtil repositoryUtil;
    @Resource
    private FileUtil fileUtil;

    @Value("${filePath.announcementAppendixFile}")
    private String filePath;

    @Override
    public List<Announcement> getAnnouncementsByAnnouncementIds(List<Long> announcementIds) {
        return announcementRepository.findAnnouncementsByAnnouncementIdIn(announcementIds);
    }

    @Override
    public List<Announcement> getAnnouncementsByAnnouncementTitleLike(String announcementTitle) {
        return announcementRepository.findAnnouncementsByAnnouncementTitleLike(announcementTitle);
    }

    @Override
    public List<Announcement> getAnnouncementsByAnnouncementContextLike(String announcementContext) {
        return announcementRepository.findAnnouncementsByAnnouncementContextLike(announcementContext);
    }

    @Override
    public List<Announcement> getAnnouncementsByAnnouncementDepartment(long departmentId) {
        return announcementRepository.findAnnouncementsByAnnouncementDepartment_DepartmentId(departmentId);
    }

    @Override
    public List<Announcement> getAnnouncementsByAnnouncementDateBetween(Date minDate, Date maxDate) {
        return announcementRepository.findAnnouncementsByAnnouncementDateBetween(minDate, maxDate);
    }

    @Override
    public boolean modifyAnnouncement(Announcement announcement) {
        return saveAnnouncement(announcement);
    }

    @Override
    public boolean delAnnouncement(List<Long> announcementIds) {
        List<Announcement> announcements = announcementRepository.findAllById(announcementIds);
        for (Announcement announcement : announcements) {
            List<AnnouncementAppendixFile> appendixFiles = announcement.getAnnouncementAppendixFiles();
            for (AnnouncementAppendixFile appendixFile : appendixFiles) {
                if (!repositoryUtil.delete(announcementAppendixFileRepository, appendixFile) && fileUtil.delFile(appendixFile.getFile())) {
                    return false;
                }
            }
            if (!repositoryUtil.delete(announcementRepository, announcement)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Announcement> getAnnouncementsByAnnouncementState(int announcementState) {
        return announcementRepository.findAnnouncementsByAnnouncementState(announcementState);
    }

    @Override
    public boolean saveAnnouncement(Announcement announcement) {
        announcement.setAnnouncementState(1);
        return repositoryUtil.save(announcementRepository,announcement);
    }

    @Override
    public boolean publishAnnouncement(Announcement announcement) {
        announcement.setAnnouncementState(2);
        return repositoryUtil.save(announcementRepository,announcement);
    }

    @Override
    public boolean recallAnnouncements(List<Long> announcementIds) {
        return announcementRepository.recallAnnouncements(announcementIds) != -1;
    }

    @Override
    public boolean saveAnnouncementAppendixFile(MultipartFile file, long announcementId, String filename) {
        Announcement announcement = announcementRepository.findAnnouncementByAnnouncementId(announcementId);
        File newFile = fileUtil.saveMultipartFile(file, filePath, announcementId +"_"+ System.currentTimeMillis()+"_"+filename);
        if (newFile == null) {
            return false;
        }
        AnnouncementAppendixFile announcementAppendixFile = new AnnouncementAppendixFile();
        announcementAppendixFile.setAnnouncement(announcement);
        announcementAppendixFile.setFile(newFile);
        announcementAppendixFile.setName(filename);
        return repositoryUtil.save(announcementAppendixFileRepository,announcementAppendixFile);
    }

    @Override
    public boolean delAnnouncementAppendixFile(long appendixFileId) {
        AnnouncementAppendixFile appendixFile = announcementAppendixFileRepository.findAnnouncementAppendixFileByFileId(appendixFileId);
        return repositoryUtil.delete(announcementAppendixFileRepository, appendixFile) && fileUtil.delFile(appendixFile.getFile());
    }

    @Override
    public List<Announcement> getAllAnnouncement() {
        return announcementRepository.findAll();
    }

    @Override
    public ResponseEntity<byte[]> getFile(long fileId) {
        File file = announcementAppendixFileRepository.findAnnouncementAppendixFileByFileId(fileId).getFile();
        return fileUtil.getResponseEntity(file);
    }

}
