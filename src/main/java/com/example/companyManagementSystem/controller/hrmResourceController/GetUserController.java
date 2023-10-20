package com.example.companyManagementSystem.controller.hrmResourceController;

import com.example.companyManagementSystem.entity.hrmResource.User;

import java.util.Date;
import java.util.List;

public interface GetUserController {
    List<User> getUserLikeUsername(String username);

    List<User> getUserLikeEmail(String email);

    List<User> getUserByCreateTime(Date minCreateTime, Date maxCreateTime);

    List<User> getUsersByUserIds(List<Long> userIds);

    List<User> getUserByPersonalId(long personalId);
    List<User> getUserByPersonalName(String name);

    List<User> getUserByRoleGroup(Long roleGroupId);

    List<User> getAllUser();
    List<User> getUserByRoleTypeId(Long roleTypeId);
}
