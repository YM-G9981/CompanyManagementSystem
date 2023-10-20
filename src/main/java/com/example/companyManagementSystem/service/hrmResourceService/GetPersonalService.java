package com.example.companyManagementSystem.service.hrmResourceService;

import com.example.companyManagementSystem.entity.hrmResource.Personal;

import java.util.Date;
import java.util.List;

public interface GetPersonalService {
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

    List<Personal> getPersonalsBelow(long personalId);

    List<Personal> getAllPersonals();

    List<Personal> getPersonalsByPositionId(long positionId);
}
