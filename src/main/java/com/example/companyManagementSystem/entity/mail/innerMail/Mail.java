package com.example.companyManagementSystem.entity.mail.innerMail;

import com.example.companyManagementSystem.entity.hrmResource.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "inner_mails")
@Table(name = "inner_mails")
@Data
public class Mail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mail_id")
    private long mailId;
    @Column(name = "mail_title")
    @NonNull
    private String mailTitle;
    @Column(name = "mail_context")
    @NonNull
    private String mailContext;
    @Column(name = "mail_summary")
    private String mailSummary;
    @OneToMany(mappedBy = "mail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("mail")
    private List<AppendixFile> appendixFiles;
    @Column(name = "send_time")
    @NonNull
    private Date sendTime;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "addresser", referencedColumnName = "user_id")
    @NonNull
    private User addresser;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "addressee", referencedColumnName = "user_id")
    @NonNull
    private User addressee;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "reply_from", referencedColumnName = "mail_id")
    @JsonIncludeProperties({"mailId","mailTitle"})
    private Mail replyFrom;
    @Column(name = "mail_state")
    @NonNull
    private int mailState;

    /**
     * 1 未读 已删除 0未发送
     */
    public Mail() {

    }
}
