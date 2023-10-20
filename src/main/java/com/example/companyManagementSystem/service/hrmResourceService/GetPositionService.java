package com.example.companyManagementSystem.service.hrmResourceService;

import com.example.companyManagementSystem.entity.hrmResource.Position;

import java.util.List;

public interface GetPositionService {
    Position getPositionByPositionId(long positionId);


    Position getPositionByPositionName(String positionName);

    List<Position> getAllPositions();
}
