package com.example.companyManagementSystem.entity.hrmResource;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "positions", uniqueConstraints = @UniqueConstraint(columnNames = "position_name"))
public class Position implements Serializable {
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @ExcelIgnore
    private long positionId;
    @Column(name = "position_name")
    @NonNull
    @ExcelProperty("职位名称")
    private String positionName;
    @Column(name = "position_describe")
    @ExcelProperty("职位描述")
    @NonNull
    private String positionDescribe;

    public Position() {
    }
}
