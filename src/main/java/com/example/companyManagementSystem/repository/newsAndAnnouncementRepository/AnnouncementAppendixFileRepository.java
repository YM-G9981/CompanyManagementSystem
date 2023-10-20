package com.example.companyManagementSystem.repository.newsAndAnnouncementRepository;

import com.example.companyManagementSystem.entity.newsAndAnnouncement.AnnouncementAppendixFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementAppendixFileRepository extends JpaRepository<AnnouncementAppendixFile, Long> {


    AnnouncementAppendixFile findAnnouncementAppendixFileByFileId(long fileId);
}
