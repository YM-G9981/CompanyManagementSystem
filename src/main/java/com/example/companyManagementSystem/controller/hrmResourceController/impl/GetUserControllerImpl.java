package com.example.companyManagementSystem.controller.hrmResourceController.impl;

import com.example.companyManagementSystem.controller.hrmResourceController.GetUserController;
import com.example.companyManagementSystem.entity.hrmResource.User;
import com.example.companyManagementSystem.service.hrmResourceService.GetUserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/getUser")
public class GetUserControllerImpl implements GetUserController {
    @Resource
    private GetUserService getUserService;

    @PostMapping("/getUserLikeUsername/{username}")
    @Override
    public List<User> getUserLikeUsername(@PathVariable String username) {
        return getUserService.getUsersLikeUsername(username);
    }

    @PostMapping("/getUserLikeEmail/{email}")
    @Override
    public List<User> getUserLikeEmail(@PathVariable String email) {
        return getUserService.getUsersLikeEmail(email);
    }

    @PostMapping("/getUserByCreateTime/{minCreateTime}/{maxCreateTime}")
    @Override
    public List<User> getUserByCreateTime(@PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") Date minCreateTime,
                                          @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") Date maxCreateTime) {
        return getUserService.getUsersByCreateTime(minCreateTime, maxCreateTime);
    }
    @PostMapping("/getUsersByUserIds")
    @Override
    public List<User> getUsersByUserIds(@RequestBody List<Long> userIds) {
        return getUserService.getUsersByUserIds(userIds);
    }
    @PostMapping("/getUserByPersonalId/{personalId}")
    @Override
    public List<User> getUserByPersonalId(@PathVariable long personalId) {
        return getUserService.getUserByPersonalId(personalId);
    }
    @PostMapping("/getUserByPersonalName/{name}")
    @Override
    public List<User> getUserByPersonalName(@PathVariable String name) {
        return getUserService.getUserByPersonalName("%"+name+"%");
    }

    @PostMapping("/getUserByRoleGroup/{roleGroupId}")
    @Override
    public List<User> getUserByRoleGroup(@PathVariable Long roleGroupId) {
        return getUserService.getUsersByRoleGroup(roleGroupId);
    }
    @PostMapping("/getAllUsers")
    @Override
    public List<User> getAllUser() {
        return getUserService.getAllUser();
    }

    @PostMapping("/getUserByRoleTypeId/{roleGroupId}")
    @Override
    public List<User> getUserByRoleTypeId(@PathVariable Long roleTypeId) {
        return getUserService.getUsersByRoleTypeId(roleTypeId);
    }
}
