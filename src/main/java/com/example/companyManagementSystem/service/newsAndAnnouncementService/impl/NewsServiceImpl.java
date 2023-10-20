package com.example.companyManagementSystem.service.newsAndAnnouncementService.impl;

import com.example.companyManagementSystem.entity.newsAndAnnouncement.News;
import com.example.companyManagementSystem.entity.newsAndAnnouncement.NewsAppendixFile;
import com.example.companyManagementSystem.repository.newsAndAnnouncementRepository.NewsAppendixFileRepository;
import com.example.companyManagementSystem.repository.newsAndAnnouncementRepository.NewsRepository;
import com.example.companyManagementSystem.service.newsAndAnnouncementService.NewsService;
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
public class NewsServiceImpl implements NewsService {
    @Resource
    private FileUtil fileUtil;
    @Resource
    private NewsRepository newsRepository;
    @Resource
    private NewsAppendixFileRepository newsAppendixFileRepository;
    @Resource
    private RepositoryUtil repositoryUtil;
    @Value("${filePath.newsAppendixFile}")
    private String filePath;


    @Override
    public List<News> getNewsByNewsIds(List<Long> newsIds) {
        return newsRepository.findAllById(newsIds);
    }

    @Override
    public List<News> getNewsByNewsTitle(String newsTitle) {
        return newsRepository.findAllByNewsTitleLike(newsTitle);
    }

    @Override
    public List<News> getNewsByNewsCreateTimeBetween(Date minDate, Date maxDate) {
        return newsRepository.findAllByCreateTimeBetween(minDate, maxDate);
    }

    @Override
    public boolean modifyNews(News news) {
        if (news.getNewsState() != 0) {
            return false;
        }
        return saveNews(news);
    }

    @Override
    public boolean delNews(List<Long> newsIds) {
        for(Long newsId:newsIds) {
            List<Long> appendixFileIds = newsAppendixFileRepository.findNewsAppendixFileIdsByNewsId(newsId);
            for (long appendixFileId : appendixFileIds) {
                delNewsAppendixFile(appendixFileId);
            }
        }
        return repositoryUtil.deleteAllById(newsRepository, newsIds);
    }

    @Override
    public boolean publishNews(News news) {
        news.setNewsState(2);
        return saveNews(news);
    }

    @Override
    public boolean saveNews(News news) {
        return repositoryUtil.save(newsRepository, news);
    }

    @Override
    public boolean saveNewsAppendixFile(MultipartFile file, long newsId, String name) {
        News news = newsRepository.findByNewsId(newsId);
        File newFile = fileUtil.saveMultipartFile(file, filePath, newsId +"_"+ System.currentTimeMillis()+"_"+name);
        if (newFile == null) {
            return false;
        }
        NewsAppendixFile newsAppendixFile = new NewsAppendixFile();
        newsAppendixFile.setFile(newFile);
        newsAppendixFile.setNews(news);
        newsAppendixFile.setName(name);
        news.getNewsAppendixFiles().add(newsAppendixFile);
        return saveNews(news);
    }


    @Override
    public boolean delNewsAppendixFile(long newsAppendixFileId) {
        NewsAppendixFile newsAppendixFile = newsAppendixFileRepository.findNewsAppendixFileByFileId(newsAppendixFileId);
        return repositoryUtil.delete(newsAppendixFileRepository, newsAppendixFile) && fileUtil.delFile(newsAppendixFile.getFile());
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public ResponseEntity<byte[]> getFile(long fileId) {
        File file = newsAppendixFileRepository.findNewsAppendixFileByFileId(fileId).getFile();
        return fileUtil.getResponseEntity(file);
    }

    @Override
    public List<News> getNewsByNewsState(int state) {
        return newsRepository.findAllByNewsState(state);
    }
}
