package com.example.companyManagementSystem.service.attendanceService;

import com.example.companyManagementSystem.entity.attendance.Sign;

import java.util.Date;
import java.util.List;

public interface GetSignRecordService {
    List<Sign> getAllSignRecord();

    List<Sign> getSignRecordByDepartmentId(long departmentId, Date minDate, Date maxDate);

    List<Sign> getSignRecordByPositionId(long positionId, Date minDate, Date maxDate);

    List<Sign> getSignRecordByPersonalId(long personalId, Date minDate, Date maxDate);

    List<Sign> getSignRecordLikeName(String name, Date minDate, Date maxDate);

    List<Sign> getSignRecordBySex(int sex, Date minDate, Date maxDate);

    List<Sign> getSignRecordByState(int state, Date minDate, Date maxDate);

}
