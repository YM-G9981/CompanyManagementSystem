package com.example.companyManagementSystem.controller.missionController;

import com.example.companyManagementSystem.entity.mission.Mission;

import java.util.Date;
import java.util.List;

public interface MissionController {
    List<Mission> getMissionsByMissionIds(List<Long> missionIds);

    List<Mission> getMissionsByMissionType(long missionTypeId);
    List<Mission> getMissionsByMissionTitle(String title);

    List<Mission> getMissionsByMissionTimeBetween(Date minDate, Date maxDate);

    List<Mission> getMissionsByDeadlineTimeBetween(Date minDate, Date maxDate);

    List<Mission> getMissionsByMissState(boolean missionState);

    List<Mission> getMissionsByMissionInitiateUser(long missionInitiateUserId);

    List<Mission> getMissionsByMissionUser(long missionUserId);

    List<Mission> getAllMissions();

    boolean saveMission(Mission mission);

    boolean modifyMission(Mission mission);

    boolean delMissions(List<Long> missionIds);
}
