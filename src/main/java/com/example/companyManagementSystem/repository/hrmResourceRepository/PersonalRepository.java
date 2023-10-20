package com.example.companyManagementSystem.repository.hrmResourceRepository;

import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.example.companyManagementSystem.entity.hrmResource.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Long> {
    /**根据Id查找职员*/
    List<Personal> findPersonalsByPersonalId(long personalId);
    /**根据姓名查找职员*/
    Personal findPersonalByName(String name);
    /**根据姓名查找姓名中含有该字的职员**/
    List<Personal> findPersonalsByNameLike(String name);
    /**根据性别查找职员*/
    List<Personal> findPersonalsBySex(int sex);
    /**根据年龄查找职员*/
    List<Personal> findPersonalsByAgeBetween(int minAge, int maxAge);
    /**根据生日查找职员*/
    List<Personal> findPersonalsByBirthdayBetween(Date minDate, Date maxDate);
    /**根据电话查找职员*/
    List<Personal> findPersonalsByPhoneLike(String phone);
    /**根据雇佣日期查找职员*/
    List<Personal> findPersonalsByHireDateBetween(Date minDate, Date maxDate);
    /**根据身份证查找职员*/
    List<Personal> findPersonalsByIDNumberLike(String idNumber);
    /**根据状态查找职员*/
    List<Personal> findPersonalsByState(int state);
    /**根据部门查找职员*/
    List<Personal> findPersonalsByDepartment(Department department);
    /**根据部门ID查找职员*/
    List<Personal> findPersonalsByDepartment_DepartmentId(long departmentId);
    /**根据工号查找职员*/
    List<Personal> findPersonalsByJobNumberLike(String jobNumber);
    /**根据职位查找职员*/
    List<Personal> findPersonalsByPositionPositionId(long positionId);

}
