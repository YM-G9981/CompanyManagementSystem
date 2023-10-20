package com.example.companyManagementSystem.service.hrmResourceService.impl;

import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PersonalRepository;
import com.example.companyManagementSystem.service.hrmResourceService.GetPersonalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class GetPersonalServiceImpl implements GetPersonalService {
    @Resource
    private PersonalRepository personalRepository;
    /**根据ID查找职员*/
    @Override
    public List<Personal> getPersonalById(Long personalId) {
        return personalRepository.findPersonalsByPersonalId(personalId);
    }
    /**根据姓名查找职员*/
    @Override
    public List<Personal> getPersonalLikeName(String name) {
        return personalRepository.findPersonalsByNameLike(name);
    }
    /**根据性别查找人员*/
    @Override
    public List<Personal> getPersonalBySex(int sex) {
        return personalRepository.findPersonalsBySex(sex);
    }
    /**根据年龄查找职员*/
    @Override
    public List<Personal> getPersonalByAge(int minAge, int maxAge) {
        return personalRepository.findPersonalsByAgeBetween(minAge, maxAge);
    }
    /**根据生日查找职员*/
    @Override
    public List<Personal> getPersonalByBirthday(Date minDate, Date maxDate) {
        return personalRepository.findPersonalsByBirthdayBetween(minDate, maxDate);
    }
    /**根据电话查找职员*/
    @Override
    public List<Personal> getPersonalLikePhone(String phone) {
        return personalRepository.findPersonalsByPhoneLike(phone);
    }
    /**根据雇佣日期查找职员*/
    @Override
    public List<Personal> getPersonalByHireDate(Date minDate, Date maxDate) {
        return personalRepository.findPersonalsByHireDateBetween(minDate, maxDate);
    }
    /**根据身份证号查找职员*/
    @Override
    public List<Personal> getPersonalLikeIDNumber(String idNumber) {
        return personalRepository.findPersonalsByIDNumberLike(idNumber);
    }
    /**根据人员状态查找职员*/
    @Override
    public List<Personal> getPersonalByState(int state) {
        return personalRepository.findPersonalsByState(state);
    }
    /**根据部门查找职员*/
    @Override
    public List<Personal> getPersonalByDepartmentId(long departmentId) {
        return personalRepository.findPersonalsByDepartment_DepartmentId(departmentId);
    }
    /**根据工号查找职员*/
    @Override
    public List<Personal> getPersonalLikeJobNumber(String jobNumber) {
        return personalRepository.findPersonalsByJobNumberLike(jobNumber);
    }
    /**根据上级查找职员*/
    @Transactional
    @Override
    public List<Personal> getPersonalsBelow(long personalId) {
        List<Personal> personals = getPersonalById(personalId);
        if(personals.size()==0) {
            return personals;
        }else {
            for (int i = 0; i < personals.size(); i++) {
                Personal personal = personals.get(i);
                personals.addAll(personal.getJuniors());
            }
        }
        return personals;
    }
    /**查找所有职员*/
    @Override
    public List<Personal> getAllPersonals() {
        return personalRepository.findAll();
    }
    /**根据职位查找职员*/
    @Override
    public List<Personal> getPersonalsByPositionId(long positionId) {
        return personalRepository.findPersonalsByPositionPositionId(positionId);
    }

}
