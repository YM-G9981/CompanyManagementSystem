package com.example.companyManagementSystem.service.newsAndAnnouncementService;

import com.example.companyManagementSystem.entity.newsAndAnnouncement.News;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface NewsService {
    List<News> getNewsByNewsIds(List<Long> newsId);

    List<News> getNewsByNewsTitle(String newsTitle);

    List<News> getNewsByNewsCreateTimeBetween(Date minDate, Date maxDate);

    boolean modifyNews(News news);

    boolean delNews(List<Long> newsId);

    boolean publishNews(News news);

    boolean saveNews(News news);

    boolean saveNewsAppendixFile(MultipartFile file, long newsId, String name);

    boolean delNewsAppendixFile(long newsAppendixFileId);

    List<News> getAllNews();

    ResponseEntity<byte[]> getFile(long fileId);

    List<News> getNewsByNewsState(int state);
}
