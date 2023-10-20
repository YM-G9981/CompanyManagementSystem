package com.example.companyManagementSystem.service.missionService;

import com.example.companyManagementSystem.entity.mission.Mission;

import java.util.Date;
import java.util.List;

public interface MissionService {
    List<Mission> getMissionsByMissionIds(List<Long> missionIds);

    List<Mission> getMissionsByMissionType(long missionTypeId);

    List<Mission> getMissionsByMissionTimeBetween(Date minDate, Date maxDate);

    List<Mission> getMissionsByDeadlineTimeBetween(Date minDate, Date maxDate);

    List<Mission> getMissionsByMissState(boolean missionState);

    List<Mission> getMissionsByMissionInitiateUser(long missionInitiateUserId);

    List<Mission> getMissionsByMissionUser(long missionUserId);

    boolean saveMission(Mission mission);

    boolean modifyMission(Mission mission);

    boolean delMissions(List<Long> missionIds);

    List<Mission> getAllMissions();

    List<Mission> getMissionsByMissionTitle(String title);
}
