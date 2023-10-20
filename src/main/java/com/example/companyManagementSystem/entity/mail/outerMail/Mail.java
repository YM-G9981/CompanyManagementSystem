package com.example.companyManagementSystem.entity.mail.outerMail;

import com.example.companyManagementSystem.entity.hrmResource.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "outer_mails")
@Table(name = "outer_mails")
public class Mail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mail_Id")
    private long mailId;
    @Column(name = "subject")
    @NonNull
    private String subject;
    @Column(name = "text")
    @NonNull
    private String text;
    @Column(name = "send_to")
    @NonNull
    private String sendTo;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user", referencedColumnName = "user_id")
    @NonNull
    private User user;
    @Column(name = "mail_state")
    @NonNull
    private int mailState;
    @OneToMany(mappedBy = "mail", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("mail")
    private List<AppendixFile> appendixFiles;
    @Column(name = "send_time")
    @NonNull
    private Date sendTime;

    public Mail() {
    }
}