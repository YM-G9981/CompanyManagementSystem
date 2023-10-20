package com.example.companyManagementSystem.repository.missionRepository;

import com.example.companyManagementSystem.entity.mission.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    List<Mission> findMissionsByMissionType_MissionTypeId(long missionTypeId);

    List<Mission> findMissionsByMissionTimeBetween(Date minDate, Date maxDate);

    List<Mission> findMissionsByDeadlineTimeBetween(Date minDate, Date maxDate);

    List<Mission> findMissionsByMissionState(boolean missionState);

    List<Mission> findMissionsByMissionInitiateUser_UserId(long userId);

    @Query(value = "select * from missions m " +
            "left join mission_user mu on m.mission_id=mu.mission_id" +
            "where mu.user_id =?1", nativeQuery = true)
    List<Mission> findMissionsByMissionUser(long userId);

    List<Mission> findMissionsByMissionTitleIsLike(String title);

}
