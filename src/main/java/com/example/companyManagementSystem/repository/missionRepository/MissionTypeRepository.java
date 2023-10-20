package com.example.companyManagementSystem.repository.missionRepository;

import com.example.companyManagementSystem.entity.mission.MissionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionTypeRepository extends JpaRepository<MissionType, Long> {
}
