package com.example.companyManagementSystem.service.hrmResourceService.impl;

import com.example.companyManagementSystem.entity.hrmResource.Position;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PositionRepository;
import com.example.companyManagementSystem.service.hrmResourceService.GetPositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GetPositionServiceImpl implements GetPositionService {
    @Resource
    private PositionRepository positionRepository;

    @Override
    public Position getPositionByPositionId(long positionId) {
        return positionRepository.findPositionByPositionId(positionId);
    }
    @Override
    public Position getPositionByPositionName(String positionName) {
        return positionRepository.findPositionsByPositionName(positionName);
    }

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }
}
