package com.example.companyManagementSystem.controller.attendanceController.impl;

import com.example.companyManagementSystem.controller.attendanceController.ExportSignRecordController;
import com.example.companyManagementSystem.service.attendanceService.ExportSignRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/exportSignRecord")
public class ExportSignRecordControllerImpl implements ExportSignRecordController {
    @Resource
    private ExportSignRecordService exportSignRecordService;

    @GetMapping("/getAllSignRecord")
    @Override
    public ResponseEntity<byte[]> getAllSignRecord() {
        return exportSignRecordService.getAllSignRecord();
    }

    @GetMapping("/getSignRecordByDepartmentId/{departmentId}/{minDate},{maxDate}")
    @Override
    public ResponseEntity<byte[]> getSignRecordByDepartmentId(@PathVariable long departmentId, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return exportSignRecordService.getSignRecordByDepartmentId(departmentId, minDate, maxDate);
    }

    @GetMapping("/getSignRecordByPositionId/{positionId}/{minDate},{maxDate}")
    @Override
    public ResponseEntity<byte[]> getSignRecordByPositionId(@PathVariable long positionId, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return exportSignRecordService.getSignRecordByPositionId(positionId, minDate, maxDate);
    }

    @GetMapping("/getSignRecordByPersonalId/{personalId}/{minDate},{maxDate}")
    @Override
    public ResponseEntity<byte[]> getSignRecordByPersonalId(@PathVariable long personalId, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return exportSignRecordService.getSignRecordByPersonalId(personalId, minDate, maxDate);
    }

    @GetMapping("/getSignRecordLikeName/{name}/{minDate},{maxDate}")
    @Override
    public ResponseEntity<byte[]> getSignRecordLikeName(@PathVariable String name, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return exportSignRecordService.getSignRecordLikeName(name, minDate, maxDate);
    }

    @GetMapping("/getSignRecordBySex/{sex}/{minDate}/{maxDate}")
    @Override
    public ResponseEntity<byte[]> getSignRecordBySex(@PathVariable int sex, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return exportSignRecordService.getSignRecordBySex(sex, minDate, maxDate);
    }

    @GetMapping("/getSignRecordLikeIDNumber/{idNumber}/{minDate}/{maxDate}")
    @Override
    public ResponseEntity<byte[]> getSignRecordLikeIDNumber(@PathVariable String idNumber, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return exportSignRecordService.getSignRecordLikeIDNumber(idNumber, minDate, maxDate);
    }

    @GetMapping("/getSignRecordByState/{state}/{minDate}/{maxDate}")
    @Override
    public ResponseEntity<byte[]> getSignRecordByState(@PathVariable int state, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return exportSignRecordService.getSignRecordByState(state, minDate, maxDate);
    }


    @GetMapping("/getSignRecordLikeJobNumber/{jobNumber}/{minDate}/{maxDate}")
    @Override
    public ResponseEntity<byte[]> getSignRecordLikeJobNumber(@PathVariable String jobNumber, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return exportSignRecordService.getSignRecordLikeJobNumber(jobNumber, minDate, maxDate);
    }
}
