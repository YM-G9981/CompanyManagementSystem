package com.example.companyManagementSystem.controller.hrmResourceController;

import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.example.companyManagementSystem.entity.hrmResource.Position;

import java.util.List;

public interface ModifyHrmResourceController {
    boolean singleModifyPersonal(Personal personal);

    boolean batchModifyPersonals(List<Personal> personals);

    boolean singleModifyDepartment(Department department);

    boolean batchModifyDepartments(List<Department> departments);

    boolean singleModifyPosition(Position department);

    boolean batchModifyPositions(List<Position> positions);

}
