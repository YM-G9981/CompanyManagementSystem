package com.example.companyManagementSystem.service.hrmResourceService;

import java.util.List;

public interface DropHrmResourceService {
    boolean dropDepartments(List<Long> departments);

    boolean dropPositions(List<Long> positions);

    boolean dropPersonals(List<Long> personals);

    boolean dropUsers(List<Long> userIds);
}
