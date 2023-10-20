package com.example.companyManagementSystem.entity.hrmResource;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.example.companyManagementSystem.entity.attendance.SignRule;
import com.example.companyManagementSystem.utils.converterUtils.hrmResourceConverterUtils.*;
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
@Table(name = "personals", uniqueConstraints = @UniqueConstraint(columnNames = "jobNumber"))
public class Personal implements Serializable {
    @Column(name = "personal_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelIgnore
    private long personalId;
    @Column(name = "jobNumber")
    @ExcelProperty("工号")
    @NonNull
    private String jobNumber;
    @Column(name = "name")
    @ExcelProperty("姓名")
    @NonNull
    private String name;
    @Column(name = "sex")
    @ExcelProperty(value = "性别", converter = GenderConverterUtil.class)
    @NonNull
    private int sex;
    @ExcelProperty("年龄")
    @Column(name = "age")
    @NonNull
    private int age;
    @Column(name = "birthday")
    @ExcelProperty("出生日期")
    @NonNull
    private Date birthday;
    @Column(name = "phone")
    @ExcelProperty("电话")
    @NonNull
    private String phone;
    @Column(name = "hire_date")
    @ExcelProperty("入职日期")
    @NonNull
    private Date hireDate;
    @Column(name = "id_number")
    @ExcelProperty("身份证号")
    @NonNull
    private String IDNumber;
    @Column(name = "state")
    @ExcelProperty(value = "人员状态", converter = PersonalStateConverterUtil.class)
    @NonNull
    private int state;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "superior", referencedColumnName = "personal_id")
    @ExcelProperty(value = "直接上级", converter = PersonalConverterUtil.class)
    @JsonIncludeProperties({"personalId","jobNumber","name"})
    private Personal superior;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "department", referencedColumnName = "department_id")
    @ExcelProperty(value = "部门", converter = DepartmentConverterUtil.class)
    @JsonIgnoreProperties("personals")
    @NonNull
    private Department department;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "position_name", referencedColumnName = "position_id")
    @ExcelProperty(value = "职位", converter = PositionConverterUtil.class)
    @NonNull
    private Position position;
    /**直接下级*/
    @ExcelIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH,mappedBy = "superior")
    @JsonIncludeProperties({"personalId","jobNumber","name"})
    private List<Personal> juniors;
    /**签到规则*/
    @ExcelIgnore
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "sign_rule_id",referencedColumnName = "sign_rule_id")
    private SignRule signRule;
    /**绑定用户*/
    @JsonIgnoreProperties("personal")
    @ExcelIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "personal")
    private User user;


    public Personal() {
    }
}
