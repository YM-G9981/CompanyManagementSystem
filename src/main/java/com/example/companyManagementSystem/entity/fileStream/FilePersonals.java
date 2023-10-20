package com.example.companyManagementSystem.entity.fileStream;

import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "file_personals")
public class FilePersonals implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_personal_id")
    private long filePersonalId;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "file_stream",referencedColumnName = "file_stream_id")
    @NonNull
    @JsonIgnore
    private FileStream fileStream;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @JoinColumn(name = "personal",referencedColumnName = "personal_id")
    @NonNull
    private Personal personal;
    @Column(name = "file_index")
    @NonNull
    private int index;
    @Column(name = "pass")
    private Boolean pass;
    @Column(name = "pass_date")
    private Date passDate;
    @Column(name = "remarks")
    private String remarks;
    public FilePersonals() {

    }
}
