package com.example.companyManagementSystem.service.hrmResourceService.impl;

import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.example.companyManagementSystem.entity.hrmResource.departmentList.DepartmentListNode;
import com.example.companyManagementSystem.entity.hrmResource.departmentList.DepartmentListTree;
import com.example.companyManagementSystem.entity.hrmResource.personalList.PersonalListNode;
import com.example.companyManagementSystem.entity.hrmResource.personalList.PersonalListTree;
import com.example.companyManagementSystem.repository.hrmResourceRepository.DepartmentRepository;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PersonalRepository;
import com.example.companyManagementSystem.service.hrmResourceService.GetListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayDeque;
import java.util.List;

@Service
public class GetListServiceImpl implements GetListService {
    @Resource
    private DepartmentRepository departmentRepository;
    @Resource
    private PersonalRepository personalRepository;

    @Override
    public PersonalListTree getPersonalListTreeByDepartmentId(long departmentId) {
        Department rootDepartment = departmentRepository.findDepartmentByDepartmentId(departmentId);
        ArrayDeque<PersonalListNode> personalListNodes = new ArrayDeque<>();
        PersonalListNode rootPersonalListNode = new PersonalListNode(rootDepartment);
        personalListNodes.add(rootPersonalListNode);
        PersonalListTree personalListTree = new PersonalListTree(rootPersonalListNode);
        while (personalListNodes.size() > 0) {
            PersonalListNode personalListNode = personalListNodes.removeFirst();
            Department department = personalListNode.getDepartment();
            List<Personal> personals = personalRepository.findPersonalsByDepartment(department);
            personalListNode.getPersonals().addAll(personals);
            List<Department> juniorDepartments = departmentRepository.findAllBySuperiorDepartment(department);
            for (Department juniorDepartment : juniorDepartments) {
                PersonalListNode juniorPersonalListNode = new PersonalListNode(juniorDepartment);
                personalListNode.getJuniorPersonalListNodes().add(juniorPersonalListNode);
                personalListNodes.add(juniorPersonalListNode);
            }
        }
        return personalListTree;
    }

    @Override
    public DepartmentListTree getDepartmentListTreeByDepartmentId(long departmentId) {
        Department rootDepartment = departmentRepository.findDepartmentByDepartmentId(departmentId);
        ArrayDeque<DepartmentListNode> departmentListNodes = new ArrayDeque<>();
        DepartmentListNode rootDepartmentListNode = new DepartmentListNode(rootDepartment);
        departmentListNodes.add(rootDepartmentListNode);
        DepartmentListTree departmentListTree = new DepartmentListTree(rootDepartmentListNode);
        while (departmentListNodes.size() > 0) {
            DepartmentListNode departmentListNode = departmentListNodes.removeFirst();
            Department department = departmentListNode.getDepartment();
            List<Department> juniorDepartments = departmentRepository.findAllBySuperiorDepartment(department);
            for (Department juniorDepartment : juniorDepartments) {
                DepartmentListNode juniorDepartmentListNode = new DepartmentListNode(juniorDepartment);
                departmentListNode.getJuniorDepartmentListNodes().add(juniorDepartmentListNode);
                departmentListNodes.add(juniorDepartmentListNode);
            }
        }
        return departmentListTree;
    }

}
