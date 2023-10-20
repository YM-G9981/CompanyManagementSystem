package com.example.companyManagementSystem.entity.newsAndAnnouncement;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;

@Entity
@Table(name = "news_appendix_files")
@Data
public class NewsAppendixFile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private long fileId;
    @Column(name = "file")
    @NonNull
    private File file;
    @Column(name = "file_name")
    @NonNull
    private String name;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "news", referencedColumnName = "news_id")
    private News news;

    public NewsAppendixFile() {

    }
}
