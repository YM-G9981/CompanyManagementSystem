package com.example.companyManagementSystem.controller.hrmResourceController;

import com.example.companyManagementSystem.entity.hrmResource.Position;

import java.util.List;

public interface GetPositionController {
    Position getPositionByPositionId(long positionId);

    List<Position> getAllPositions();

    Position getPositionByPositionName(String positionName);
}
