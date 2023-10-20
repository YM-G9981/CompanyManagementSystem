package com.example.companyManagementSystem.controller.attendanceController;

import com.example.companyManagementSystem.entity.attendance.Sign;

import java.util.Date;
import java.util.List;

public interface GetSignRecordController {
    List<Sign> getAllSignRecord();

    List<Sign> getSignRecordByDepartmentId(long departmentId, Date minDate, Date maxDate);

    List<Sign> getSignRecordByPositionId(long positionId, Date minDate, Date maxDate);

    List<Sign> getSignRecordByPersonalId(long personalId, Date minDate, Date maxDate);

    List<Sign> getSignRecordLikeName(String name, Date minDate, Date maxDate);

    List<Sign> getSignRecordBySex(int sex, Date minDate, Date maxDate);

    List<Sign> getSignRecordByState(int state, Date minDate, Date maxDate);

}
