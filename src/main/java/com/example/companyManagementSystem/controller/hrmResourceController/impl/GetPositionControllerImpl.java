package com.example.companyManagementSystem.controller.hrmResourceController.impl;

import com.example.companyManagementSystem.controller.hrmResourceController.GetPositionController;
import com.example.companyManagementSystem.entity.hrmResource.Position;
import com.example.companyManagementSystem.service.hrmResourceService.GetPositionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/getPosition")
public class GetPositionControllerImpl implements GetPositionController {
    @Resource
    private GetPositionService getPositionService;

    @Override
    @PostMapping("/getPositionByPositionId/{positionId}")
    public Position getPositionByPositionId(@PathVariable long positionId) {
        return getPositionService.getPositionByPositionId(positionId);
    }

    @Override
    @PostMapping("/getAllPositions")
    public List<Position> getAllPositions() {
        return getPositionService.getAllPositions();
    }

    @Override
    @PostMapping("/getPositionByPositionName")
    public Position getPositionByPositionName(@RequestBody String positionName) {
        return getPositionService.getPositionByPositionName(positionName);
    }
}
