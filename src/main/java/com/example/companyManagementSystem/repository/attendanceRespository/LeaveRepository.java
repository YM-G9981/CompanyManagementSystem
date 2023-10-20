package com.example.companyManagementSystem.repository.attendanceRepository;

import com.example.companyManagementSystem.entity.attendance.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
    @Query(value = "select * from leaves where leave_personal = ?1 and" +
            "?2 between leave_begin_date and leave_end_date", nativeQuery = true)
    List<Leave> findByPersonalAndDate(long personalId, Date date);

    List<Leave> findLeavesByLeavePersonal_Department_DepartmentIdAndLeaveEndDateAfterAndLeaveBeginDateBefore(long departmentId, Date minDate, Date maxDate);

    List<Leave> findLeavesByLeavePersonal_Position_PositionIdAndLeaveEndDateAfterAndLeaveBeginDateBefore(long positionId, Date minDate, Date maxDate);

    List<Leave> findLeavesByLeavePersonal_PersonalIdAndLeaveEndDateAfterAndLeaveBeginDateBefore(long personalId, Date minDate, Date maxDate);

    List<Leave> findLeavesByLeavePersonal_NameLikeAndLeaveEndDateAfterAndLeaveBeginDateBefore(String name, Date minDate, Date maxDate);

    List<Leave> findLeavesByLeavePersonal_SexAndLeaveEndDateAfterAndLeaveBeginDateBefore(int sex, Date minDate, Date maxDate);

    List<Leave> findLeavesByLeavePersonal_IDNumberAndLeaveEndDateAfterAndLeaveBeginDateBefore(String idNumber, Date minDate, Date maxDate);

    List<Leave> findLeavesByLeavePersonal_StateAndLeaveEndDateAfterAndLeaveBeginDateBefore(int state, Date minDate, Date maxDate);

    List<Leave> findLeavesByLeavePersonal_JobNumberLikeAndLeaveEndDateAfterAndLeaveBeginDateBefore(String jobNumber, Date minDate, Date maxDate);
}
