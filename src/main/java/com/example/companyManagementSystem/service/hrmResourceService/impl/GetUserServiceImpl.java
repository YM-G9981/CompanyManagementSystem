package com.example.companyManagementSystem.service.hrmResourceService.impl;

import com.example.companyManagementSystem.entity.hrmResource.User;
import com.example.companyManagementSystem.repository.hrmResourceRepository.UserRepository;
import com.example.companyManagementSystem.service.hrmResourceService.GetUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class GetUserServiceImpl implements GetUserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public List<User> getUsersLikeUsername(String username) {
        return userRepository.findAllByUsernameLike(username);
    }

    @Override
    public List<User> getUsersLikeEmail(String email) {
        return userRepository.findAllByEmailLike(email);
    }

    @Override
    public List<User> getUsersByCreateTime(Date minCreateTime, Date maxCreateTime) {
        return userRepository.findAllByCreateTimeBetween(minCreateTime, maxCreateTime);
    }

    @Override
    public User getUsersByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public List<User> getUsersByUserIds(List<Long> userIds) {
        return userRepository.findAllByUserIdIn(userIds);
    }

    @Override
    public List<User> getUsersByRoleGroup(Long roleGroupId) {
        return userRepository.findUsersByRoleGroup(roleGroupId);
    }

    @Override
    public List<User> getUsersByRoleTypeId(Long roleTypeId) {
        return userRepository.findUserByRoleType(roleTypeId);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUserByPersonalId(long personalId) {
        return userRepository.findAllByPersonal_PersonalId(personalId);
    }

    @Override
    public List<User> getUserByPersonalName(String name) {
        return userRepository.findAllByPersonalNameLike(name);
    }
}
