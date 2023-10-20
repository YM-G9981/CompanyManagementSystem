package com.example.companyManagementSystem.repository.newsAndAnnouncementRepository;

import com.example.companyManagementSystem.entity.newsAndAnnouncement.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> findAnnouncementsByAnnouncementIdIn(List<Long> announcementIds);

    List<Announcement> findAnnouncementsByAnnouncementTitleLike(String announcementTitle);

    List<Announcement> findAnnouncementsByAnnouncementContextLike(String announcementContext);

    List<Announcement> findAnnouncementsByAnnouncementDepartment_DepartmentId(long departmentId);

    Announcement findAnnouncementByAnnouncementId(long announcementId);

    List<Announcement> findAnnouncementsByAnnouncementDateBetween(Date minDate, Date maxDate);

    @Query(value = "update announcements set announcement_state = 0 where accouncement_id in (?1)", nativeQuery = true)
    @Modifying
    @Transactional
    int recallAnnouncements(List<Long> announcementIds);

    List<Announcement> findAnnouncementsByAnnouncementState(int announcementId);
}
