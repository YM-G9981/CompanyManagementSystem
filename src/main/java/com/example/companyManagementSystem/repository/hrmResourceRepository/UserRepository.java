package com.example.companyManagementSystem.repository.hrmResourceRepository;

import com.example.companyManagementSystem.entity.hrmResource.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

    List<User> findAllByUsernameLike(String username);

    List<User> findAllByEmailLike(String email);

    List<User> findAllByUserIdIn(List<Long> userIds);

    List<User> findAllByCreateTimeBetween(Date minCreateTime, Date maxCreateTime);

    boolean existsUserByUsernameLike(String username);
    @Query(value = "select * from users u inner join" +
            " user_role_group ur on u.user_id = ur.user_id where " +
            "ur.user_group_id = ?1",nativeQuery = true)
    List<User> findUsersByRoleGroup(long roleGroupId);
    @Query(value = "select * from users u inner join" +
            " user_role_group ur on u.user_id = ur.user_id " +
            "inner join roles r on r.role_group = ur.role_group_id where " +
            "r.role_type = ?1",nativeQuery = true)
    List<User> findUserByRoleType(Long roleTypeId);

    List<User> findAllByPersonal_PersonalId(long personalId);

    List<User> findAllByPersonalNameLike(String name);
}
