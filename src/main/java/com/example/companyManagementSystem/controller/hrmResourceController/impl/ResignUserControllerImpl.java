package com.example.companyManagementSystem.controller.hrmResourceController.impl;

import com.example.companyManagementSystem.controller.hrmResourceController.ResignUserController;
import com.example.companyManagementSystem.entity.hrmResource.User;
import com.example.companyManagementSystem.service.hrmResourceService.ResignUserService;
import com.example.companyManagementSystem.utils.utils.PasswordUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/resignUser")
public class ResignUserControllerImpl implements ResignUserController {
    @Resource
    private ResignUserService resignUserService;
    @Resource
    private PasswordUtil passwordUtil;

    @PostMapping("/resignFromPersonal")
    @Override
    public boolean resignFromPersonal(@RequestBody User resignUser, @RequestBody String key, @RequestBody String verificationCode) {
        return resignUserService.resignFromPersonal(resignUser, key, verificationCode);
    }

    @PostMapping("/resignFromAdministrator")
    @Override
    public boolean resignFromAdministrator(@RequestBody User resignUser) {
        return resignUserService.resignFromAdministrator(resignUser);
    }

    @PostMapping("/sendEmail")
    @Override
    public boolean sendResignEmail(@RequestBody String emailAddress, @RequestBody String username, @RequestBody String key) {
        return resignUserService.sendResignEmail(emailAddress, username, key);
    }

    @PostMapping("/checkUsernameUnique/{username}")
    @Override
    public boolean checkUsernameUnique(@PathVariable String username) {
        return resignUserService.checkUsernameUnique(username);
    }
}
