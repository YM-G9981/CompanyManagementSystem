package com.example.companyManagementSystem.entity.hrmResource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements Serializable {

    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(name = "username")
    @NonNull
    private String username;
    @Column(name = "password")
    @NonNull
    private String password;
    @Column(name = "email")
    private String email;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE})
    @JsonIgnoreProperties("user")
    @JoinColumn(name = "personal",referencedColumnName = "personal_id")
    private Personal personal;
    @CreationTimestamp
    @Column(name = "create_time")
    @NonNull
    private Date createTime;

    public User() {
    }
}
