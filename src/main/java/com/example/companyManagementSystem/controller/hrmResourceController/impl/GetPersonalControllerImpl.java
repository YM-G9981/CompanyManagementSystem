package com.example.companyManagementSystem.controller.hrmResourceController.impl;

import com.example.companyManagementSystem.controller.hrmResourceController.GetPersonalController;
import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.example.companyManagementSystem.service.hrmResourceService.GetPersonalService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/getPersonal")
public class GetPersonalControllerImpl implements GetPersonalController {
    @Resource
    private GetPersonalService getPersonalService;
    /** 根据职员在数据库中的ID查找职员*/
    @PostMapping("/getPersonalById/{personalId}")
    @Override
    public List<Personal> getPersonalById(@PathVariable Long personalId) {
        return getPersonalService.getPersonalById(personalId);
    }
    /** 查找全部职员*/
    @PostMapping("/getAllPersonals")
    @Override
    public List<Personal> getAllPersonals() {
        return getPersonalService.getAllPersonals();
    }
    /** 根据姓名查找职员*/
    @PostMapping("/getPersonalLikeName/{name}")
    @Override
    public List<Personal> getPersonalLikeName(@PathVariable String name) {
        return getPersonalService.getPersonalLikeName("%"+name+"%");
    }
    /** 根据性别查找职员*/
    @PostMapping("/getPersonalBySex/{sex}")
    @Override
    public List<Personal> getPersonalBySex(@PathVariable int sex) {
        return getPersonalService.getPersonalBySex(sex);
    }
    /**根据年龄查找职员*/
    @PostMapping("/getPersonalByAge/{minAge}/{maxAge}")
    @Override
    public List<Personal> getPersonalByAge(@PathVariable int minAge, @PathVariable int maxAge) {
        return getPersonalService.getPersonalByAge(minAge, maxAge);
    }
    /**根据生日查找职员*/
    @PostMapping("/getPersonalByBirthday/{minDate},{maxDate}")
    @Override
    public List<Personal> getPersonalByBirthday(@PathVariable  Date minDate, @PathVariable Date maxDate) {
        return getPersonalService.getPersonalByBirthday(minDate, maxDate);
    }
    /**根据电话查找职员*/
    @PostMapping("/getPersonalLikePhone/{phone}")
    @Override
    public List<Personal> getPersonalLikePhone(@PathVariable String phone) {
        return getPersonalService.getPersonalLikePhone("%"+phone+"%");
    }
    /**根据雇佣日期查找职员*/
    @PostMapping("/getPersonalByHireDate/{minDate},{maxDate}")
    @Override
    public List<Personal> getPersonalByHireDate(@PathVariable  Date minDate, @PathVariable  Date maxDate) {
        return getPersonalService.getPersonalByHireDate(minDate, maxDate);
    }
    /**根据身份证号码查找职员*/
    @PostMapping("/getPersonalLikeIDNumber/{idNumber}")
    @Override
    public List<Personal> getPersonalLikeIDNumber(@PathVariable String idNumber) {
        return getPersonalService.getPersonalLikeIDNumber("%"+idNumber+"%");
    }
    /**根据人员状态查找职员*/
    @PostMapping("/getPersonalByState/{state}")
    @Override
    public List<Personal> getPersonalByState(@PathVariable int state) {
        return getPersonalService.getPersonalByState(state);
    }
    /**根据人员所处部门查找职员*/
    @PostMapping("/getPersonalByDepartmentId/{departmentId}")
    @Override
    public List<Personal> getPersonalByDepartmentId(@PathVariable long departmentId) {
        return getPersonalService.getPersonalByDepartmentId(departmentId);
    }

    /**根据人员工号查找职员*/
    @PostMapping("/getPersonalLikeJobNumber/{jobNumber}")
    @Override
    public List<Personal> getPersonalLikeJobNumber(@PathVariable String jobNumber) {
        return getPersonalService.getPersonalLikeJobNumber("%"+jobNumber+"%");
    }
    /**根据上级查找职员*/
    @PostMapping("/getPersonalsBlow/{personalId}")
    @Override
    public List<Personal> getPersonalsBlow(@PathVariable long personalId) {
        return getPersonalService.getPersonalsBelow(personalId);
    }
    /**根据职位查找职员*/
    @PostMapping("/getPersonalsByPositionId/{positionId}")
    @Override
    public List<Personal> getPersonalsByPositionId(@PathVariable long positionId) {
        return getPersonalService.getPersonalsByPositionId(positionId);
    }

}
