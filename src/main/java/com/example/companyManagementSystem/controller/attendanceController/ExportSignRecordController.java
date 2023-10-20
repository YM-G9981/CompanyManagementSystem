package com.example.companyManagementSystem.controller.attendanceController;

import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface ExportSignRecordController {
    ResponseEntity<byte[]> getAllSignRecord();

    ResponseEntity<byte[]> getSignRecordByDepartmentId(long departmentId, Date minDate, Date maxDate);

    ResponseEntity<byte[]> getSignRecordByPositionId(long positionId, Date minDate, Date maxDate);

    ResponseEntity<byte[]> getSignRecordByPersonalId(long personalId, Date minDate, Date maxDate);

    ResponseEntity<byte[]> getSignRecordLikeName(String name, Date minDate, Date maxDate);

    ResponseEntity<byte[]> getSignRecordBySex(int sex, Date minDate, Date maxDate);

    ResponseEntity<byte[]> getSignRecordLikeIDNumber(String idNumber, Date minDate, Date maxDate);

    ResponseEntity<byte[]> getSignRecordByState(int state, Date minDate, Date maxDate);

    ResponseEntity<byte[]> getSignRecordLikeJobNumber(String jobNumber, Date minDate, Date maxDate);
}
