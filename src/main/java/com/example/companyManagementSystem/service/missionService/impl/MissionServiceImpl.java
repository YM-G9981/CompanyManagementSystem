package com.example.companyManagementSystem.service.missionService.impl;

import com.example.companyManagementSystem.entity.mission.Mission;
import com.example.companyManagementSystem.repository.missionRepository.MissionRepository;
import com.example.companyManagementSystem.service.missionService.MissionService;
import com.example.companyManagementSystem.utils.utils.RepositoryUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class MissionServiceImpl implements MissionService {
    @Resource
    private MissionRepository missionRepository;
    @Resource
    private RepositoryUtil repositoryUtil;

    @Override
    public List<Mission> getMissionsByMissionIds(List<Long> missionIds) {
        return missionRepository.findAllById(missionIds);
    }

    @Override
    public List<Mission> getMissionsByMissionType(long missionTypeId) {
        return missionRepository.findMissionsByMissionType_MissionTypeId(missionTypeId);
    }

    @Override
    public List<Mission> getMissionsByMissionTimeBetween(Date minDate, Date maxDate) {
        return missionRepository.findMissionsByMissionTimeBetween(minDate, maxDate);
    }

    @Override
    public List<Mission> getMissionsByDeadlineTimeBetween(Date minDate, Date maxDate) {
        return missionRepository.findMissionsByDeadlineTimeBetween(minDate, maxDate);
    }

    @Override
    public List<Mission> getMissionsByMissState(boolean missionState) {
        return missionRepository.findMissionsByMissionState(missionState);
    }

    @Override
    public List<Mission> getMissionsByMissionInitiateUser(long missionInitiateUserId) {
        return missionRepository.findMissionsByMissionInitiateUser_UserId(missionInitiateUserId);
    }

    @Override
    public List<Mission> getMissionsByMissionUser(long missionUserId) {
        return missionRepository.findMissionsByMissionUser(missionUserId);
    }

    @Override
    public boolean saveMission(Mission mission) {
        return repositoryUtil.save(missionRepository, mission);
    }

    @Override
    public boolean modifyMission(Mission mission) {
        return saveMission(mission);
    }

    @Override
    public boolean delMissions(List<Long> missionIds) {
        return repositoryUtil.deleteAllById(missionRepository, missionIds);
    }

    @Override
    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }

    @Override
    public List<Mission> getMissionsByMissionTitle(String title) {
        return missionRepository.findMissionsByMissionTitleIsLike(title);
    }
}
