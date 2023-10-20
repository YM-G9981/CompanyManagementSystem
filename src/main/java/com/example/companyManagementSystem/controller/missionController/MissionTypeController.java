package com.example.companyManagementSystem.controller.missionController;

import com.example.companyManagementSystem.entity.mission.MissionType;

import java.util.List;

public interface MissionTypeController {
    List<MissionType> getAllMissionType();

    boolean saveMissionType(MissionType missionType);

    boolean delMissionTypesByMissionTypeIds(List<Long> missionTypeId);

}
