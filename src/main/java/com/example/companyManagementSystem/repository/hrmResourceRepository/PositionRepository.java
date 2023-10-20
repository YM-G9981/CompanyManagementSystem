package com.example.companyManagementSystem.repository.hrmResourceRepository;

import com.example.companyManagementSystem.entity.hrmResource.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    List<Position> findPositionsByPositionNameLike(String positionName);

    Position findPositionsByPositionName(String positionName);

    Position findPositionByPositionId(long positionId);

}
