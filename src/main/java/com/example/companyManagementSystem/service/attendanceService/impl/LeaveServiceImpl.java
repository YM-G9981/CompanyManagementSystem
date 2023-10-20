package com.example.companyManagementSystem.service.attendanceService.impl;

import com.example.companyManagementSystem.entity.attendance.Leave;
import com.example.companyManagementSystem.repository.attendanceRepository.LeaveRepository;
import com.example.companyManagementSystem.service.attendanceService.LeaveService;
import com.example.companyManagementSystem.utils.utils.RepositoryUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Resource
    private LeaveRepository leaveRepository;
    @Resource
    private RepositoryUtil repositoryUtil;

    @Override
    public List<Leave> getLeavesByPersonalAndDate(long personalId, Date date) {
        return leaveRepository.findByPersonalAndDate(personalId, date);
    }

    @Override
    public boolean saveLeave(Leave leave) {
        return repositoryUtil.save(leaveRepository, leave);
    }

    @Override
    public List<Leave> getLeavesByDepartmentId(long departmentId, Date minDate, Date maxDate) {
        return leaveRepository.findLeavesByLeavePersonal_Department_DepartmentIdAndLeaveEndDateAfterAndLeaveBeginDateBefore(departmentId, minDate, maxDate);
    }

    @Override
    public List<Leave> getLeavesByPositionId(long positionId, Date minDate, Date maxDate) {
        return leaveRepository.findLeavesByLeavePersonal_Position_PositionIdAndLeaveEndDateAfterAndLeaveBeginDateBefore(positionId, minDate, maxDate);
    }

    @Override
    public List<Leave> getLeavesByPersonalId(long personalId, Date minDate, Date maxDate) {
        return leaveRepository.findLeavesByLeavePersonal_PersonalIdAndLeaveEndDateAfterAndLeaveBeginDateBefore(personalId, minDate, maxDate);
    }

    @Override
    public List<Leave> getLeavesLikeName(String name, Date minDate, Date maxDate) {
        return leaveRepository.findLeavesByLeavePersonal_NameLikeAndLeaveEndDateAfterAndLeaveBeginDateBefore( "%"+name+"%", minDate, maxDate);
    }

    @Override
    public List<Leave> getLeavesBySex(int sex, Date minDate, Date maxDate) {
        return leaveRepository.findLeavesByLeavePersonal_SexAndLeaveEndDateAfterAndLeaveBeginDateBefore(sex, minDate, maxDate);
    }

    @Override
    public List<Leave> getLeavesLikeIDNumber(String idNumber, Date minDate, Date maxDate) {
        return leaveRepository.findLeavesByLeavePersonal_IDNumberAndLeaveEndDateAfterAndLeaveBeginDateBefore(idNumber, minDate, maxDate);
    }

    @Override
    public List<Leave> getLeavesByState(int state, Date minDate, Date maxDate) {
        return leaveRepository.findLeavesByLeavePersonal_StateAndLeaveEndDateAfterAndLeaveBeginDateBefore(state, minDate, maxDate);
    }

    @Override
    public List<Leave> getLeavesLikeJobNumber(String jobNumber, Date minDate, Date maxDate) {
        return leaveRepository.findLeavesByLeavePersonal_JobNumberLikeAndLeaveEndDateAfterAndLeaveBeginDateBefore(jobNumber, minDate, maxDate);
    }

    @Override
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public boolean delLeaves(List<Long> leaves) {
        try {
            leaveRepository.deleteAllById(leaves);
        }catch (Exception e){
            return false;
        }
        return  true;
    }
}
