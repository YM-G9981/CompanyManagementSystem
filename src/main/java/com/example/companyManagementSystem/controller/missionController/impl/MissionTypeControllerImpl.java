package com.example.companyManagementSystem.controller.missionController.impl;

import com.example.companyManagementSystem.controller.missionController.MissionTypeController;
import com.example.companyManagementSystem.entity.mission.MissionType;
import com.example.companyManagementSystem.service.missionService.MissionTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/missionType")
public class MissionTypeControllerImpl implements MissionTypeController {
    @Resource
    private MissionTypeService missionTypeService;

    @PostMapping("/getAllMissionType")
    @Override
    public List<MissionType> getAllMissionType() {
        return missionTypeService.getAllMissionType();
    }

    @PostMapping("/saveMissionType")
    @Override
    public boolean saveMissionType(@RequestBody MissionType missionType) {
        return missionTypeService.saveMissionType(missionType);
    }

    @PostMapping("/delMissionTypesByMissionTypeIds")
    @Override
    public boolean delMissionTypesByMissionTypeIds(@RequestBody List<Long> missionTypeIds) {
        return missionTypeService.delMissionTypesByMissionTypeIds(missionTypeIds);
    }
}
