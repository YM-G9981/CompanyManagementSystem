package com.example.companyManagementSystem.service.newsAndAnnouncementService;

import com.example.companyManagementSystem.entity.newsAndAnnouncement.Announcement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface AnnouncementService {
    List<Announcement> getAnnouncementsByAnnouncementIds(List<Long> announcementIds);

    List<Announcement> getAnnouncementsByAnnouncementTitleLike(String announcementTitle);

    List<Announcement> getAnnouncementsByAnnouncementContextLike(String announcementContext);

    List<Announcement> getAnnouncementsByAnnouncementDepartment(long departmentId);

    List<Announcement> getAnnouncementsByAnnouncementDateBetween(Date minDate, Date maxDate);

    boolean modifyAnnouncement(Announcement announcement);

    boolean delAnnouncement(List<Long> announcementIds);

    List<Announcement> getAnnouncementsByAnnouncementState(int announcementState);

    boolean saveAnnouncement(Announcement announcement);

    boolean publishAnnouncement(Announcement announcement);

    boolean recallAnnouncements(List<Long> announcementIds);


    boolean delAnnouncementAppendixFile(long appendixFileId);

    List<Announcement> getAllAnnouncement();

    ResponseEntity<byte[]> getFile(long fileId);

    boolean saveAnnouncementAppendixFile(MultipartFile file, long announcementId, String filename);
}
