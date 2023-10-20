package com.example.companyManagementSystem.controller.newsAndAnnouncementController;

import com.example.companyManagementSystem.entity.newsAndAnnouncement.News;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface NewsController {
    List<News> getNewsByNewsIds(List<Long> newsIds);

    List<News> getNewsByNewsTitle(String newsTitle);

    List<News> getNewsByNewsCreateTimeBetween(Date minDate, Date maxDate);

    List<News> getNewsByNewsState(int state);
    boolean modifyNews(News news);

    boolean saveNewsAppendixFile(MultipartFile file, long newsId, String name);
    boolean delNews(List<Long> newsIds);

    List<News> getAllNews();

    boolean publishNews(News news);

    boolean saveNews(News news);

    ResponseEntity<byte[]> getFile(long fileId);

    boolean delNewsAppendixFile(long newsAppendixFileId);

}