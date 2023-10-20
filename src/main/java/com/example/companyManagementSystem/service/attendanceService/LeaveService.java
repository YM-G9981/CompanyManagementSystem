package com.example.companyManagementSystem.service.attendanceService;

import com.example.companyManagementSystem.entity.attendance.Leave;

import java.util.Date;
import java.util.List;

public interface LeaveService {
    List<Leave> getLeavesByPersonalAndDate(long personalId, Date date);

    boolean saveLeave(Leave leave);

    List<Leave> getLeavesByDepartmentId(long departmentId, Date minDate, Date maxDate);

    List<Leave> getLeavesByPositionId(long positionId, Date minDate, Date maxDate);

    List<Leave> getLeavesByPersonalId(long personalId, Date minDate, Date maxDate);

    List<Leave> getLeavesLikeName(String name, Date minDate, Date maxDate);

    List<Leave> getLeavesBySex(int sex, Date minDate, Date maxDate);

    List<Leave> getLeavesLikeIDNumber(String idNumber, Date minDate, Date maxDate);

    List<Leave> getLeavesByState(int state, Date minDate, Date maxDate);

    List<Leave> getLeavesLikeJobNumber(String jobNumber, Date minDate, Date maxDate);

    List<Leave> getAllLeaves();

    boolean delLeaves(List<Long> leaves);
}
