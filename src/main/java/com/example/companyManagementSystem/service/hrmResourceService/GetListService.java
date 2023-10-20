package com.example.companyManagementSystem.service.hrmResourceService;

import com.example.companyManagementSystem.entity.hrmResource.departmentList.DepartmentListTree;
import com.example.companyManagementSystem.entity.hrmResource.personalList.PersonalListTree;

public interface GetListService {
    PersonalListTree getPersonalListTreeByDepartmentId(long departmentId);

    DepartmentListTree getDepartmentListTreeByDepartmentId(long departmentId);
}
