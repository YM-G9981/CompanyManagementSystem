package com.example.companyManagementSystem.service.attendanceService.impl;

import com.example.companyManagementSystem.entity.attendance.Sign;
import com.example.companyManagementSystem.repository.attendanceRepository.SignRepository;
import com.example.companyManagementSystem.service.attendanceService.ExportSignRecordService;
import com.example.companyManagementSystem.utils.utils.FileUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ExportSignRecordServiceImpl implements ExportSignRecordService {
    @Resource
    private FileUtil fileUtil;
    @Resource
    private SignRepository signRepository;

    @Override
    public ResponseEntity<byte[]> getAllSignRecord() {
        List<Sign> signs = signRepository.findAll();
        return fileUtil.getExcelFile(signs, Sign.class);
    }

    @Override
    public ResponseEntity<byte[]> getSignRecordByDepartmentId(long departmentId, Date minDate, Date maxDate) {
        List<Sign> signs = signRepository.findSignsBySignUser_Personal_Department_DepartmentIdAndSignTimeBetween(departmentId, minDate, maxDate);
        return fileUtil.getExcelFile(signs, Sign.class);
    }

    @Override
    public ResponseEntity<byte[]> getSignRecordByPositionId(long positionId, Date minDate, Date maxDate) {
        List<Sign> signs = signRepository.findSignsBySignUser_Personal_Position_PositionIdAndSignTimeBetween(positionId, minDate, maxDate);
        return fileUtil.getExcelFile(signs, Sign.class);
    }

    @Override
    public ResponseEntity<byte[]> getSignRecordByPersonalId(long personalId, Date minDate, Date maxDate) {
        List<Sign> signs = signRepository.findSignsBySignUser_Personal_PersonalIdAndSignTimeBetween(personalId, minDate, maxDate);
        return fileUtil.getExcelFile(signs, Sign.class);
    }

    @Override
    public ResponseEntity<byte[]> getSignRecordLikeName(String name, Date minDate, Date maxDate) {
        List<Sign> signs = signRepository.findSignsBySignUser_Personal_NameLikeAndSignTimeBetween(name, minDate, maxDate);
        return fileUtil.getExcelFile(signs, Sign.class);
    }

    @Override
    public ResponseEntity<byte[]> getSignRecordBySex(int sex, Date minDate, Date maxDate) {
        List<Sign> signs = signRepository.findSignsBySignUser_Personal_SexAndSignTimeBetween(sex, minDate, maxDate);
        return fileUtil.getExcelFile(signs, Sign.class);
    }

    @Override
    public ResponseEntity<byte[]> getSignRecordLikeIDNumber(String idNumber, Date minDate, Date maxDate) {
        List<Sign> signs = signRepository.findSignsBySignUser_Personal_IDNumberAndSignTimeBetween(idNumber, minDate, maxDate);
        return fileUtil.getExcelFile(signs, Sign.class);
    }

    @Override
    public ResponseEntity<byte[]> getSignRecordByState(int state, Date minDate, Date maxDate) {
        List<Sign> signs = signRepository.findSignsBySignUser_Personal_StateAndSignTimeBetween(state, minDate, maxDate);
        return fileUtil.getExcelFile(signs, Sign.class);
    }


    @Override
    public ResponseEntity<byte[]> getSignRecordLikeJobNumber(String jobNumber, Date minDate, Date maxDate) {
        List<Sign> signs = signRepository.findSignsBySignUser_Personal_JobNumberLikeAndSignTimeBetween(jobNumber, minDate, maxDate);
        return fileUtil.getExcelFile(signs, Sign.class);
    }
}
