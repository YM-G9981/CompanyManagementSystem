package com.example.companyManagementSystem.controller.missionController.impl;

import com.example.companyManagementSystem.controller.missionController.MissionController;
import com.example.companyManagementSystem.entity.mission.Mission;
import com.example.companyManagementSystem.service.missionService.MissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionControllerImpl implements MissionController {
    @Resource
    private MissionService missionService;

    @PostMapping("/getMissionsByMissionIds")
    @Override
    public List<Mission> getMissionsByMissionIds(@RequestBody List<Long> missionIds) {
        return missionService.getMissionsByMissionIds(missionIds);
    }

    @PostMapping("/getMissionsByMissionType/{missionTypeId}")
    @Override
    public List<Mission> getMissionsByMissionType(@PathVariable long missionTypeId) {
        return missionService.getMissionsByMissionType(missionTypeId);
    }
    @PostMapping("/getMissionsByMissionTitle/{title}")
    @Override
    public List<Mission> getMissionsByMissionTitle(@PathVariable String title) {
        return missionService.getMissionsByMissionTitle("%"+title+"%");
    }

    @PostMapping("/getMissionsByMissionTimeBetween/{minDate},{maxDate}")
    @Override
    public List<Mission> getMissionsByMissionTimeBetween(@PathVariable  Date minDate, @PathVariable  Date maxDate) {
        return missionService.getMissionsByMissionTimeBetween(minDate, maxDate);
    }

    @PostMapping("/getMissionsByDeadlineTimeBetween/{minDate},{maxDate}")
    @Override
    public List<Mission> getMissionsByDeadlineTimeBetween(@PathVariable  Date minDate, @PathVariable  Date maxDate) {
        return missionService.getMissionsByDeadlineTimeBetween(minDate, maxDate);
    }

    @PostMapping("/getMissionsByDeadlineTimeBetween/{missionState}")
    @Override
    public List<Mission> getMissionsByMissState(@PathVariable boolean missionState) {
        return missionService.getMissionsByMissState(missionState);
    }

    @PostMapping("/getMissionsByMissionInitiateUser/{missionInitiateUserId}")
    @Override
    public List<Mission> getMissionsByMissionInitiateUser(@PathVariable long missionInitiateUserId) {
        return missionService.getMissionsByMissionInitiateUser(missionInitiateUserId);
    }

    @PostMapping("/getMissionsByMissionUser/{missionUserId}")
    @Override
    public List<Mission> getMissionsByMissionUser(@PathVariable long missionUserId) {
        return missionService.getMissionsByMissionUser(missionUserId);
    }
    @PostMapping("/getAllMissions")
    @Override
    public List<Mission> getAllMissions() {
        return missionService.getAllMissions();
    }

    @PostMapping("/saveMission")
    @Override
    public boolean saveMission(@RequestBody Mission mission) {
        return missionService.saveMission(mission);
    }

    @PostMapping("/modifyMission")
    @Override
    public boolean modifyMission(@RequestBody Mission mission) {
        return missionService.modifyMission(mission);
    }

    @PostMapping("/delMissions")
    @Override
    public boolean delMissions(@RequestBody List<Long> missionIds) {
        System.out.println(missionIds);
        return missionService.delMissions(missionIds);
    }
}
