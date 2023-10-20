package com.example.companyManagementSystem.repository.attendanceRepository;

import com.example.companyManagementSystem.entity.attendance.Sign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author G-YM
 */
@Repository
public interface SignRepository extends JpaRepository<Sign, Long> {
    List<Sign> findSignsBySignUser_Personal_Department_DepartmentIdAndSignTimeBetween(long departmentId, Date minDate, Date maxDate);

    List<Sign> findSignsBySignUser_Personal_Position_PositionIdAndSignTimeBetween(long positionId, Date minDate, Date maxDate);

    List<Sign> findSignsBySignUser_Personal_PersonalIdAndSignTimeBetween(long personalId, Date minDate, Date maxDate);

    List<Sign> findSignsBySignUser_Personal_NameLikeAndSignTimeBetween(String name, Date minDate, Date maxDate);

    List<Sign> findSignsBySignUser_Personal_SexAndSignTimeBetween(int sex, Date minDate, Date maxDate);
    List<Sign> findSignsBySignUser_Personal_IDNumberAndSignTimeBetween(String idNumber, Date minDate, Date maxDate);

    List<Sign> findSignsBySignUser_Personal_StateAndSignTimeBetween(int state, Date minDate, Date maxDate);

    //    @Query(value = "select s.sign_id,s.sign_location,s.sign_picture,s.sign_time,s.user from signs s " +
//            "left join users u on s.user = u.user_id " +
//            "left join personals p on u.personal = p.personal_id " +
//            "where p.job_number like ?1 and s.sign_time between ?2 and ?3", nativeQuery = true)
    List<Sign> findSignsBySignUser_Personal_JobNumberLikeAndSignTimeBetween(String jobNumber, Date minDate, Date maxDate);
}
