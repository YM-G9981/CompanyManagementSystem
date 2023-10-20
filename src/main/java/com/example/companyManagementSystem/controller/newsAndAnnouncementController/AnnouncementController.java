package com.example.companyManagementSystem.controller.newsAndAnnouncementController;

import com.example.companyManagementSystem.entity.newsAndAnnouncement.Announcement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface AnnouncementController {
    List<Announcement> getAnnouncementsByAnnouncementIds(List<Long> announcementIds);

    List<Announcement> getAnnouncementsByAnnouncementTitleLike(String announcementTitle);

    List<Announcement> getAnnouncementsByAnnouncementContextLike(String announcementContext);

    List<Announcement> getAnnouncementsByAnnouncementDepartment(long departmentId);

    List<Announcement> getAnnouncementsByAnnouncementDateBetween(Date minDate, Date maxDate);

    List<Announcement> getAnnouncementsByAnnouncementState(int announcementState);

    List<Announcement> getAllAnnouncement();

    boolean modifyAnnouncement(Announcement announcement);

    boolean saveAnnouncement(Announcement announcement);

    boolean delAnnouncements(List<Long> announcementIds);

    boolean publishAnnouncement(Announcement announcement);

    boolean recallAnnouncements(List<Long> announcementIds);

    boolean delAnnouncementAppendixFile(long appendixFileId);

    ResponseEntity<byte[]> getFile(long fileId);

    boolean saveAnnouncementAppendixFile(MultipartFile file, long announcementId, String filename);
}
