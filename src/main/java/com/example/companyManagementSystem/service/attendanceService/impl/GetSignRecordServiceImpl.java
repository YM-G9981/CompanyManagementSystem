package com.example.companyManagementSystem.service.attendanceService.impl;

import com.example.companyManagementSystem.entity.attendance.Sign;
import com.example.companyManagementSystem.repository.attendanceRepository.SignRepository;
import com.example.companyManagementSystem.service.attendanceService.GetSignRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class GetSignRecordServiceImpl implements GetSignRecordService {
    @Resource
    private SignRepository signRepository;

    @Override
    public List<Sign> getAllSignRecord() {
        List<Sign> signs = signRepository.findAll();
        return signs;
    }

    @Override
    public List<Sign> getSignRecordByDepartmentId(long departmentId, Date minDate, Date maxDate) {
        List<Sign> signs = signRepository.findSignsBySignUser_Personal_Department_DepartmentIdAndSignTimeBetween(departmentId, minDate, maxDate);
        return signs;
    }

    @Override
    public List<Sign> getSignRecordByPositionId(long positionId, Date minDate, Date maxDate) {
        List<Sign> signs = signRepository.findSignsBySignUser_Personal_Position_PositionIdAndSignTimeBetween(positionId, minDate, maxDate);
        return signs;
    }

    @Override
    public List<Sign> getSignRecordByPersonalId(long personalId, Date minDate, Date maxDate) {
        List<Sign> signs = signRepository.findSignsBySignUser_Personal_PersonalIdAndSignTimeBetween(personalId, minDate, maxDate);
        return signs;
    }

    @Override
    public List<Sign> getSignRecordLikeName(String name, Date minDate, Date maxDate) {
        List<Sign> signs = signRepository.findSignsBySignUser_Personal_NameLikeAndSignTimeBetween("%" + name + "%", minDate, maxDate);
        return signs;
    }

    @Override
    public List<Sign> getSignRecordBySex(int sex, Date minDate, Date maxDate) {
        List<Sign> signs = signRepository.findSignsBySignUser_Personal_SexAndSignTimeBetween(sex, minDate, maxDate);
        return signs;
    }

    @Override
    public List<Sign> getSignRecordByState(int state, Date minDate, Date maxDate) {
        List<Sign> signs = signRepository.findSignsBySignUser_Personal_StateAndSignTimeBetween(state, minDate, maxDate);
        return signs;
    }


}
