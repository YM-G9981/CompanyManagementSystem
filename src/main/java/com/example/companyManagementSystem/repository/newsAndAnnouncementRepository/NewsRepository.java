package com.example.companyManagementSystem.repository.newsAndAnnouncementRepository;

import com.example.companyManagementSystem.entity.newsAndAnnouncement.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllByNewsTitleLike(String newsTitle);

    List<News> findAllByCreateTimeBetween(Date minDate, Date maxDate);

    List<News> findAllByNewsState(int state);

    News findByNewsId(long Id);

}
