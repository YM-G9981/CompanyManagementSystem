package com.example.companyManagementSystem.entity.mail.outerMail;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;

@Entity(name = "outer_mail_appendix_files")
@Table(name = "outer_mail_appendix_files")
@Data
public class AppendixFile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private long fileId;
    @Column(name = "file")
    @NonNull
    private File file;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mail", referencedColumnName = "mail_id")
    private Mail mail;

    @Column(name ="name")
    @NonNull
    private String name;
    public AppendixFile() {

    }
}
