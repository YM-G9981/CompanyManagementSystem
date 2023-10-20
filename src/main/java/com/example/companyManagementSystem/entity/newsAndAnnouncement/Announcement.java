package com.example.companyManagementSystem.entity.newsAndAnnouncement;

import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "announcements")
public class Announcement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "announcement_id")
    @NonNull
    private long announcementId;
    @Column(name = "announcement_title")
    @NonNull
    private String announcementTitle;
    @Column(name = "announcement_context")
    @NonNull
    private String announcementContext;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "announcement_department", referencedColumnName = "department_id")
    @NonNull
    private Department announcementDepartment;
    @Column(name = "announcement_date")
    @NonNull
    private Date announcementDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "announcement", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("announcement")
    private List<AnnouncementAppendixFile> announcementAppendixFiles;
    @Column(name = "announcement_state")
    @NonNull
    private int announcementState;

    public Announcement() {
    }
    /**
     * 0 保存 1 发送
     */
}
