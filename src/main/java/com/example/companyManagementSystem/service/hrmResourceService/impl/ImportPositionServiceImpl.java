package com.example.companyManagementSystem.service.hrmResourceService.impl;

import com.alibaba.excel.EasyExcel;
import com.example.companyManagementSystem.entity.hrmResource.Position;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PositionRepository;
import com.example.companyManagementSystem.service.hrmResourceService.ImportPositionService;
import com.example.companyManagementSystem.utils.utils.FileUtil;
import com.example.companyManagementSystem.utils.utils.RepositoryUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

@Service
public class ImportPositionServiceImpl implements ImportPositionService {
    @Resource
    private PositionRepository positionRepository;
    @Resource
    private FileUtil fileUtil;
    @Value("${filePath.importPositionsTemple}")
    private String fileName;
    @Resource
    private HttpServletRequest request;
    @Resource
    private RepositoryUtil repositoryUtil;

    @Override
    public boolean singleImportPosition(Position position) {
        return repositoryUtil.save(positionRepository, position);
    }

    @Override
    public boolean batchImportPositions(MultipartFile multipartFile) {
        List<Position> positions = new LinkedList<>();
        try {
            List<Position> list = EasyExcel.read(multipartFile.getInputStream()).head(Position.class).sheet().doReadSync();
            positions.addAll(list);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return repositoryUtil.saveAll(positionRepository, positions);
    }

    @Override
    public ResponseEntity<byte[]> getBatchImportPositionsTemple() {
        String filePath = request.getServletContext().getRealPath(fileName);
        File file = new File(filePath);
        return fileUtil.getResponseEntity(file);
    }
}
