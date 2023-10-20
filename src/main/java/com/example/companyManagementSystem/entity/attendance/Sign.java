package com.example.companyManagementSystem.entity.attendance;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.example.companyManagementSystem.entity.hrmResource.User;
import com.example.companyManagementSystem.utils.converterUtils.attendanceConverterUtils.SignStatusConverterUtil;
import com.example.companyManagementSystem.utils.converterUtils.hrmResourceConverterUtils.UserConverterUtil;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "signs")
public class Sign implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelIgnore
    @Column(name = "sign_id")
    private long signId;
    @Column(name = "latitude")
    @NonNull
    @ExcelProperty("纬度")
    private double latitude;
    @Column(name = "longitude")
    @NonNull
    @ExcelProperty("经度")
    private double longitude;
    @Column(name = "sign_location")
    @NonNull
    @ExcelProperty("签到位置")
    private String signLocation;
    @Column(name = "sign_picture")
    @NonNull
    @ExcelProperty("签到图片")
    private File signPicture;
    @Column(name = "sign_status")
    @NonNull
    @ExcelProperty(value = "签到状态", converter = SignStatusConverterUtil.class)
    private long signStatus;
    @Column(name = "sign_time")
    @NonNull
    @ExcelProperty("签到时间")
    private Date signTime;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "sign_rule", referencedColumnName = "sign_rule_id")
    @ExcelIgnore
    private SignRule signRule;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "sign_user", referencedColumnName = "user_id")
    @ExcelProperty(value = "签到人", converter = UserConverterUtil.class)
    @NonNull
    private User signUser;

    public Sign() {
    }
}