package com.example.companyManagementSystem.service.missionService.impl;

import com.example.companyManagementSystem.entity.mission.MissionType;
import com.example.companyManagementSystem.repository.missionRepository.MissionTypeRepository;
import com.example.companyManagementSystem.service.missionService.MissionTypeService;
import com.example.companyManagementSystem.utils.utils.RepositoryUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MissionTypeServiceImpl implements MissionTypeService {
    @Resource
    private MissionTypeRepository missionTypeRepository;
    @Resource
    private RepositoryUtil repositoryUtil;

    @Override
    public List<MissionType> getAllMissionType() {
        return missionTypeRepository.findAll();
    }

    @Override
    public boolean saveMissionType(MissionType missionType) {
        return repositoryUtil.save(missionTypeRepository, missionType);
    }

    @Override
    public boolean delMissionTypesByMissionTypeIds(List<Long> missionTypeIds) {
        return repositoryUtil.deleteAllById(missionTypeRepository, missionTypeIds);
    }
}
