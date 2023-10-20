package com.example.companyManagementSystem.controller.hrmResourceController;

import com.example.companyManagementSystem.entity.hrmResource.Personal;

import java.util.Date;
import java.util.List;

public interface GetPersonalController {
    List<Personal> getAllPersonals();
    List<Personal> getPersonalById(Long personalId);

    List<Personal> getPersonalLikeName(String name);

    List<Personal> getPersonalBySex(int sex);

    List<Personal> getPersonalByAge(int minAge, int maxAge);

    List<Personal> getPersonalByBirthday(Date minDate, Date maxDate);

    List<Personal> getPersonalLikePhone(String phone);

    List<Personal> getPersonalByHireDate(Date minDate, Date maxDate);

    List<Personal> getPersonalLikeIDNumber(String idNumber);

    List<Personal> getPersonalByState(int state);

    List<Personal> getPersonalByDepartmentId(long departmentId);

    List<Personal> getPersonalLikeJobNumber(String jobNumber);

    List<Personal> getPersonalsBlow(long personalId);

    List<Personal> getPersonalsByPositionId(long positionId);
}
