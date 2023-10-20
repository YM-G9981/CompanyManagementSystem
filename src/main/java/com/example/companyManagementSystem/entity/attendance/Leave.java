package com.example.companyManagementSystem.entity.attendance;

import com.example.companyManagementSystem.entity.hrmResource.Personal;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "leaves")
public class Leave implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_id")
    private long leaveId;
    @Column(name = "leave_begin_date")
    @NonNull
    private Date leaveBeginDate;
    @Column(name = "leave_end_date")
    @NonNull
    private Date leaveEndDate;
    @OneToOne(fetch = FetchType.LAZY, cascade =CascadeType.DETACH)
    @JoinColumn(name = "leave_personal", referencedColumnName = "personal_id")
    @NonNull
    private Personal leavePersonal;

    public Leave() {
    }
}
