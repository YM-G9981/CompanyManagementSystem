package com.example.companyManagementSystem.service.missionService;

import com.example.companyManagementSystem.entity.mission.MissionType;

import java.util.List;

public interface MissionTypeService {
    List<MissionType> getAllMissionType();

    boolean saveMissionType(MissionType missionType);

    boolean delMissionTypesByMissionTypeIds(List<Long> missionTypeIds);
}
