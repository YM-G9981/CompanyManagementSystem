package com.example.companyManagementSystem.controller.hrmResourceController;

import java.util.List;

public interface DropHrmResourceController {
    boolean dropDepartments(List<Long> departments);

    boolean dropPositions(List<Long> positions);

    boolean dropPersonals(List<Long> personals);

    boolean dropUsers(List<Long> users);
}
