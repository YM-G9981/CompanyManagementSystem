package com.example.companyManagementSystem.controller.newsAndAnnouncementController.impl;

import com.example.companyManagementSystem.controller.newsAndAnnouncementController.AnnouncementController;
import com.example.companyManagementSystem.entity.newsAndAnnouncement.Announcement;
import com.example.companyManagementSystem.service.newsAndAnnouncementService.AnnouncementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/announcement")
public class AnnouncementControllerImpl implements AnnouncementController {
    @Resource
    private AnnouncementService announcementService;

    @PostMapping("/getAnnouncementsByAnnouncementIds")
    @Override
    public List<Announcement> getAnnouncementsByAnnouncementIds(@RequestBody List<Long> announcementIds) {
        return announcementService.getAnnouncementsByAnnouncementIds(announcementIds);
    }

    @PostMapping("/getAnnouncementsByAnnouncementTitleLike/{announcementTitle}")
    @Override
    public List<Announcement> getAnnouncementsByAnnouncementTitleLike(@PathVariable String announcementTitle) {
        return announcementService.getAnnouncementsByAnnouncementTitleLike("%"+announcementTitle+"%");
    }
    @PostMapping("/getAnnouncementsByAnnouncementContextLike/{announcementContext}")
    @Override
    public List<Announcement> getAnnouncementsByAnnouncementContextLike(@PathVariable String announcementContext) {
        return announcementService.getAnnouncementsByAnnouncementContextLike("%"+announcementContext+"%");
    }
    @PostMapping("/getAnnouncementsByAnnouncementDepartment/{departmentId}")
    @Override
    public List<Announcement> getAnnouncementsByAnnouncementDepartment(@PathVariable long departmentId) {
        return announcementService.getAnnouncementsByAnnouncementDepartment(departmentId);
    }
    @PostMapping("/getAnnouncementsByAnnouncementDateBetween/{minDate},{maxDate}")
    @Override
    public List<Announcement> getAnnouncementsByAnnouncementDateBetween(@PathVariable Date minDate, @PathVariable Date maxDate) {
        return announcementService.getAnnouncementsByAnnouncementDateBetween(minDate, maxDate);
    }
    @PostMapping("/getAnnouncementsByAnnouncementState/{announcementState}")
    @Override
    public List<Announcement> getAnnouncementsByAnnouncementState(@PathVariable int announcementState) {
        return announcementService.getAnnouncementsByAnnouncementState(announcementState);
    }
    @PostMapping("/getAllAnnouncement")
    @Override
    public List<Announcement> getAllAnnouncement() {
        return announcementService.getAllAnnouncement();
    }

    @PostMapping("/modifyAnnouncement")
    @Override
    public boolean modifyAnnouncement(@RequestBody Announcement announcement) {
        return announcementService.modifyAnnouncement(announcement);
    }

    @PostMapping("/saveAnnouncement")
    @Override
    public boolean saveAnnouncement(@RequestBody Announcement announcement) {
        return announcementService.saveAnnouncement(announcement);
    }

    @PostMapping("/delAnnouncements")
    @Override
    public boolean delAnnouncements(@RequestBody List<Long> announcementIds) {
        return announcementService.delAnnouncement(announcementIds);
    }

    @PostMapping("/publishAnnouncement")
    @Override
    public boolean publishAnnouncement(@RequestBody Announcement announcement) {
        return announcementService.publishAnnouncement(announcement);
    }

    @PostMapping("/recallAnnouncements")
    @Override
    public boolean recallAnnouncements(@RequestBody List<Long> announcementIds) {
        return announcementService.recallAnnouncements(announcementIds);
    }

    @PostMapping("/delAnnouncementAppendixFile/{appendixFileId}")
    @Override
    public boolean delAnnouncementAppendixFile(@PathVariable long appendixFileId) {
        return announcementService.delAnnouncementAppendixFile(appendixFileId);
    }
    @PostMapping("/getFile/{fileId}")
    @Override
    public ResponseEntity<byte[]> getFile(@PathVariable long fileId) {
        return announcementService.getFile(fileId);
    }

    @PostMapping("/saveAnnouncementAppendixFile/{announcementId}/{filename}")
    @Override
    public boolean saveAnnouncementAppendixFile(@RequestBody MultipartFile file, @PathVariable long announcementId, @PathVariable String filename) {
        return announcementService.saveAnnouncementAppendixFile(file,announcementId, filename);
    }

}
