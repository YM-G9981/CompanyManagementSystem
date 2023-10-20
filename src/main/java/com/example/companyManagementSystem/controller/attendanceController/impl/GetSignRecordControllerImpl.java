package com.example.companyManagementSystem.controller.attendanceController.impl;

import com.example.companyManagementSystem.controller.attendanceController.GetSignRecordController;
import com.example.companyManagementSystem.entity.attendance.Sign;
import com.example.companyManagementSystem.service.attendanceService.GetSignRecordService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/getSignRecord")
public class GetSignRecordControllerImpl implements GetSignRecordController {
    @Resource
    private GetSignRecordService getSignRecordService;

    @PostMapping("/getAllSignRecord")
    @Override
    public List<Sign> getAllSignRecord() {
        return getSignRecordService.getAllSignRecord();
    }

    @PostMapping("/getSignRecordByDepartmentId/{departmentId}/{minDate},{maxDate}")
    @Override
    public List<Sign> getSignRecordByDepartmentId(@PathVariable long departmentId, @PathVariable  Date minDate, @PathVariable  Date maxDate) {
        return getSignRecordService.getSignRecordByDepartmentId(departmentId, minDate, maxDate);
    }

    @PostMapping("/getSignRecordByPositionId/{positionId}/{minDate},{maxDate}")
    @Override
    public List<Sign> getSignRecordByPositionId(@PathVariable long positionId, @PathVariable  Date minDate, @PathVariable  Date maxDate) {
        return getSignRecordService.getSignRecordByPositionId(positionId, minDate, maxDate);
    }

    @PostMapping("/getSignRecordByPersonalId/{personalId}/{minDate},{maxDate}")
    @Override
    public List<Sign> getSignRecordByPersonalId(@PathVariable long personalId, @PathVariable Date minDate, @PathVariable  Date maxDate) {
        return getSignRecordService.getSignRecordByPersonalId(personalId, minDate, maxDate);
    }

    @PostMapping("/getSignRecordLikeName/{name}/{minDate},{maxDate}")
    @Override
    public List<Sign> getSignRecordLikeName(@PathVariable String name, @PathVariable  Date minDate, @PathVariable  Date maxDate) {
        return getSignRecordService.getSignRecordLikeName(name, minDate, maxDate);
    }

    @PostMapping("/getSignRecordBySex/{sex}/{minDate},{maxDate}")
    @Override
    public List<Sign> getSignRecordBySex(@PathVariable int sex, @PathVariable  Date minDate, @PathVariable  Date maxDate) {
        return getSignRecordService.getSignRecordBySex(sex, minDate, maxDate);
    }

    @PostMapping("/getSignRecordByState/{state}/{minDate},{maxDate}")
    @Override
    public List<Sign> getSignRecordByState(@PathVariable int state, @PathVariable  Date minDate, @PathVariable  Date maxDate) {
        return getSignRecordService.getSignRecordByState(state, minDate, maxDate);
    }


}
