package com.example.companyManagementSystem.entity.fileStream;

import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "file_stream")
@Data
public class FileStream implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_stream_id")
    private long fileStreamId;
    @Column(name = "file_stream_subject")
    @NonNull
    private String fileStreamSubject;
    @Column(name = "file_context")
    @NonNull
    private String fileContext;
    @ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
    @JoinTable(name = "file_stream_personals"
            ,inverseJoinColumns = @JoinColumn(name = "personal",referencedColumnName = "personal_id")
            ,joinColumns = {
            @JoinColumn(name = "file_stream",referencedColumnName = "file_stream_id")
    }

    )
    private List<Personal> personals;
    @Column(name = "personal_index")
    @NonNull
    private int index;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "fileId")
    @JsonIgnoreProperties("fileStream")
    private List<FileStreamAppendixFile> appendixFiles;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @NonNull
    @JoinColumn(name = "personal",referencedColumnName = "personal_id")
    private Personal personal;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "fileStream")
    private List<FilePersonals> filePersonals;
    @Column(name = "file_time")
    @NonNull
    private Date fileTime;
    public FileStream() {

    }
}
