package com.example.companyManagementSystem.entity.hrmResource;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.example.companyManagementSystem.utils.converterUtils.hrmResourceConverterUtils.DepartmentConverterUtil;
import com.example.companyManagementSystem.utils.converterUtils.hrmResourceConverterUtils.DepartmentStateConverterUtil;
import com.example.companyManagementSystem.utils.converterUtils.hrmResourceConverterUtils.PersonalConverterUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data

@Entity
@Table(name = "departments", uniqueConstraints = @UniqueConstraint(columnNames = "department_name"))
public class Department implements Serializable {
    @Column(name = "department_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelIgnore
    private long departmentId;
    @Column(name = "department_name")
    @ExcelProperty("部门名")
    @NonNull
    private String departmentName;
    @Column(name = "department_describe")
    @ExcelProperty("部门描述")
    @NonNull
    private String departmentDescribe;
    @Column(name = "department_state")
    @ExcelProperty(value = "部门状态", converter = DepartmentStateConverterUtil.class)
    @NonNull
    private int departmentState;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @ExcelProperty(value = "部门领导", converter = PersonalConverterUtil.class)
    @JoinColumn(name = "department_manager", referencedColumnName = "personal_id")
    @JsonIgnoreProperties("department")

    private Personal departmentManager;
    @Column(name = "department_location")
    @ExcelProperty(value = "部门位置")
    @NonNull
    private String departmentLocation;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "superior_department", referencedColumnName = "department_id")
    @ExcelProperty(value = "上级部门", converter = DepartmentConverterUtil.class)
    @JsonIncludeProperties({"departmentId","departmentName"})
    private Department superiorDepartment;
    @Column(name = "department_create_time")
    @ExcelProperty(value = "部门创建日期")
    @NonNull
    private Date departmentCreateTime;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    @ExcelIgnore
    @JsonIncludeProperties({"name","personalId","jobNumber"})
    private List<Personal> personals;
    public Department() {
    }
}

