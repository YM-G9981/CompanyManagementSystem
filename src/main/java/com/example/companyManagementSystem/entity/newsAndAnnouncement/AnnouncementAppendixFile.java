package com.example.companyManagementSystem.entity.newsAndAnnouncement;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;

@Entity(name = "announcement_appendix_files")
@Table(name = "announcement_appendix_files")
@Data
public class AnnouncementAppendixFile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private long fileId;
    @Column(name = "file")
    @NonNull
    private File file;
    @Column(name = "name")
    @NonNull
    private String name;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "announcement", referencedColumnName = "announcement_id")
    private Announcement announcement;

    public AnnouncementAppendixFile() {

    }
}
