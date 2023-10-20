package com.example.companyManagementSystem.repository.newsAndAnnouncementRepository;

import com.example.companyManagementSystem.entity.newsAndAnnouncement.NewsAppendixFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsAppendixFileRepository extends JpaRepository<NewsAppendixFile, Long> {
    NewsAppendixFile findNewsAppendixFileByFileId(long fileId);

    @Query(nativeQuery = true, value = "select file_id from news_appendix_files n where news = ?1")
    List<Long> findNewsAppendixFileIdsByNewsId(long newsId);


}
