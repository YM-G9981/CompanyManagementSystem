package com.example.companyManagementSystem.service.hrmResourceService;

import com.example.companyManagementSystem.entity.hrmResource.User;

import java.util.Date;
import java.util.List;

public interface GetUserService {
    List<User> getUsersLikeUsername(String username);

    List<User> getUsersLikeEmail(String email);

    List<User> getUsersByCreateTime(Date minCreateTime, Date maxCreateTime);

    User getUsersByUsername(String username);

    List<User> getUsersByUserIds(List<Long> userIds);

    List<User> getUsersByRoleGroup(Long roleGroupId);

    List<User> getUsersByRoleTypeId(Long roleTypeId);

    List<User> getAllUser();

    List<User> getUserByPersonalId(long personalId);

    List<User> getUserByPersonalName(String name);
}
