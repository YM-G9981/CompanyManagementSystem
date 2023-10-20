package com.example.companyManagementSystem.controller.newsAndAnnouncementController.impl;

import com.example.companyManagementSystem.controller.newsAndAnnouncementController.NewsController;
import com.example.companyManagementSystem.entity.newsAndAnnouncement.News;
import com.example.companyManagementSystem.service.newsAndAnnouncementService.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsControllerImpl implements NewsController {
    @Resource
    private NewsService newsService;

    @PostMapping("/getNewsByNewsIds")
    @Override
    public List<News> getNewsByNewsIds(@RequestBody List<Long> newsIds) {
        return newsService.getNewsByNewsIds(newsIds);
    }

    @PostMapping("/getNewsByNewsTitle/{newsTitle}")
    @Override
    public List<News> getNewsByNewsTitle(@PathVariable String newsTitle) {
        return newsService.getNewsByNewsTitle("%"+newsTitle+"%");
    }

    @PostMapping("/getNewsByNewsCreateTimeBetween/{minDate},{maxDate}")
    @Override
    public List<News> getNewsByNewsCreateTimeBetween(@PathVariable Date minDate, @PathVariable Date maxDate) {
        return newsService.getNewsByNewsCreateTimeBetween(minDate, maxDate);
    }
    @PostMapping("/getNewsByNewsState/{state}")
    @Override
    public List<News> getNewsByNewsState(@PathVariable int state) {
        return newsService.getNewsByNewsState(state);
    }

    @PostMapping("/modifyNews")
    @Override
    public boolean modifyNews(@RequestBody News news) {
        return newsService.modifyNews(news);
    }
    @PostMapping("/saveNewsAppendixFile/{newsId}/{filename}")
    @Override
    public boolean saveNewsAppendixFile(@RequestBody MultipartFile file, @PathVariable long newsId,@PathVariable String filename) {
        return newsService.saveNewsAppendixFile(file,newsId, filename);
    }

    @PostMapping("/delNews")
    @Override
    public boolean delNews(@RequestBody List<Long> newsIds) {
        return newsService.delNews(newsIds);
    }
    @PostMapping("/getAllNews")
    @Override
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @PostMapping("/publishNews")
    @Override
    public boolean publishNews(@RequestBody News news) {
        return newsService.publishNews(news);
    }

    @PostMapping("/saveNews")
    @Override
    public boolean saveNews(@RequestBody News news) {
        news.setNewsState(1);
        return newsService.saveNews(news);
    }
    @PostMapping("/getFile/{fileId}")
    @Override
    public ResponseEntity<byte[]> getFile(@PathVariable long fileId) {
        return newsService.getFile(fileId);
    }

    @PostMapping("/delNewsAppendixFiles/{newsAppendixFileId}")
    @Override
    public boolean delNewsAppendixFile(@PathVariable long newsAppendixFileId) {
        return newsService.delNewsAppendixFile(newsAppendixFileId);
    }
}
