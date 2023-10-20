package com.example.companyManagementSystem.controller.attendanceController.impl;

import com.example.companyManagementSystem.controller.attendanceController.LeaveController;
import com.example.companyManagementSystem.entity.attendance.Leave;
import com.example.companyManagementSystem.service.attendanceService.LeaveService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/leave")
public class LeaveControllerImpl implements LeaveController {
    @Resource
    private LeaveService leaveService;

    @Override
    @PostMapping("/getLeavesByPersonalAndDate/{personalId}/{date}")
    public List<Leave> getLeavesByPersonalAndDate(@PathVariable long personalId, @PathVariable Date date) {
        return leaveService.getLeavesByPersonalAndDate(personalId, date);
    }

    @Override
    @PostMapping("/getAllLeaves")
    public List<Leave> getAllLeaves(){
        return  leaveService.getAllLeaves();
    }

    @Override
    @PostMapping("/saveLeave")
    public boolean saveLeave(@RequestBody Leave leave) {
        return leaveService.saveLeave(leave);
    }

    @Override
    @PostMapping("/delLeaves")
    public boolean delLeaves(@RequestBody List<Long> leaves) {
        return leaveService.delLeaves(leaves);
    }

    @Override
    @PostMapping("/getLeavesByDepartmentId/{departmentId}/{minDate},{maxDate}")
    public List<Leave> getLeavesByDepartmentId(@PathVariable long departmentId, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return leaveService.getLeavesByDepartmentId(departmentId, minDate, maxDate);
    }

    @Override
    @PostMapping("/getLeavesByPositionId/{positionId}/{minDate},{maxDate}")
    public List<Leave> getLeavesByPositionId(@PathVariable long positionId, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return leaveService.getLeavesByPositionId(positionId, minDate, maxDate);
    }

    @Override
    @PostMapping("/getLeavesByPersonalId/{personalId}/{minDate},{maxDate}")
    public List<Leave> getLeavesByPersonalId(@PathVariable long personalId, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return leaveService.getLeavesByPersonalId(personalId, minDate, maxDate);
    }

    @Override
    @PostMapping("/getLeavesLikeName/{name}/{minDate},{maxDate}")
    public List<Leave> getLeavesLikeName(@PathVariable String name, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return leaveService.getLeavesLikeName("%"+name+"%", minDate, maxDate);
    }

    @Override
    @PostMapping("/getLeavesBySex/{sex}/{minDate},{maxDate}")
    public List<Leave> getLeavesBySex(@PathVariable int sex, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return leaveService.getLeavesBySex(sex, minDate, maxDate);
    }

    @Override
    @PostMapping("/getLeavesLikeIDNumber/{idNumber}/{minDate},{maxDate}")
    public List<Leave> getLeavesLikeIDNumber(@PathVariable String idNumber, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return leaveService.getLeavesLikeIDNumber(idNumber, minDate, maxDate);
    }

    @Override
    @PostMapping("/getLeavesByState/{state}/{minDate},{maxDate}")
    public List<Leave> getLeavesByState(@PathVariable int state, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return leaveService.getLeavesByState(state, minDate, maxDate);
    }

    @Override
    @PostMapping("/getLeavesLikeJobNumber/{jobNumber}/{minDate},{maxDate}")
    public List<Leave> getLeavesLikeJobNumber(@PathVariable String jobNumber, @PathVariable Date minDate, @PathVariable Date maxDate) {
        return leaveService.getLeavesLikeJobNumber(jobNumber, minDate, maxDate);
    }
}
