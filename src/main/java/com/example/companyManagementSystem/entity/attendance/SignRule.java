package com.example.companyManagementSystem.entity.attendance;

import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.List;

@Entity
@Data
@Table(name = "sign_rules")
public class SignRule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sign_rule_id")
    private long signRuleId;
    @Column(name = "sign_latitude")
    @NonNull
    private double signLatitude;
    @Column(name = "sign_longitude")
    @NonNull
    private double signLongitude;
    @Column(name = "sign_off_time")
    @NonNull
    private Time signOffTime;
    @Column(name = "sign_on_time")
    @NonNull
    private Time signOnTime;
    @Column(name = "sign_radius")
    @NonNull
    private double signRadius;
    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE}, fetch = FetchType.LAZY,mappedBy = "signRule")
    @JsonIgnoreProperties("signRule")
    private List<Personal> signPersonals;

    public SignRule() {
    }

}
