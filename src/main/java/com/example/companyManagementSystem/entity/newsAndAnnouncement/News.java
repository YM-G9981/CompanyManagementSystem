package com.example.companyManagementSystem.entity.newsAndAnnouncement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "news")
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private long newsId;
    @Column(name = "news_title")
    @NonNull
    private String newsTitle;
    @Column(name = "news_describe")
    @NonNull
    private String newsDescribe;
    @Column(name = "news_information")
    @NonNull
    private String newsInformation;
    @Column(name = "create_time")
    @NonNull
    private Date createTime;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "news")
    @JsonIgnoreProperties("news")
    private List<NewsAppendixFile> newsAppendixFiles;
    @Column(name = "news_state")
    @NonNull
    private int newsState;

    public News() {
    }
}
