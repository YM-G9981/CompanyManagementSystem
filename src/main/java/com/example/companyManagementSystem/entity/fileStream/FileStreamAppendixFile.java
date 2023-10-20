package com.example.companyManagementSystem.entity.fileStream;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.File;
@Entity
@Table(name = "file_stream_appendixFile")
@Data
public class FileStreamAppendixFile {
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
    @JoinColumn(name = "file_Stream", referencedColumnName = "file_stream_id")
    private FileStream fileStream;

    public FileStreamAppendixFile() {

    }
}
