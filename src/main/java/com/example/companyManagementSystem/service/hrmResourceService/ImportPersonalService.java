package com.example.companyManagementSystem.service.hrmResourceService;

import com.example.companyManagementSystem.entity.hrmResource.Personal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImportPersonalService {
    boolean singleImportPersonal(Personal personal);

    boolean batchImportPersonals(MultipartFile file);

    ResponseEntity<byte[]> getBatchImportPersonalsTemple();
}
