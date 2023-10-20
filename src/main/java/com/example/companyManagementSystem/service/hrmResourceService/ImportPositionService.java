package com.example.companyManagementSystem.service.hrmResourceService;

import com.example.companyManagementSystem.entity.hrmResource.Position;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImportPositionService {
    boolean singleImportPosition(Position personal);

    boolean batchImportPositions(MultipartFile file);

    ResponseEntity<byte[]> getBatchImportPositionsTemple();
}
