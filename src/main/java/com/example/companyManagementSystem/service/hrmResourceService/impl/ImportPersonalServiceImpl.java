package com.example.companyManagementSystem.service.hrmResourceService.impl;

import com.alibaba.excel.EasyExcel;
import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.example.companyManagementSystem.entity.hrmResource.Position;
import com.example.companyManagementSystem.repository.hrmResourceRepository.DepartmentRepository;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PersonalRepository;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PositionRepository;
import com.example.companyManagementSystem.service.hrmResourceService.ImportPersonalService;
import com.example.companyManagementSystem.utils.utils.FileUtil;
import com.example.companyManagementSystem.utils.utils.RepositoryUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ImportPersonalServiceImpl implements ImportPersonalService {
    @Resource
    private PersonalRepository personalRepository;
    @Resource
    private DepartmentRepository departmentRepository;
    @Resource
    private HttpServletRequest request;
    @Resource
    private PositionRepository positionRepository;
    @Resource
    private FileUtil fileUtil;
    @Value("${filePath.importPersonalsTemple}")
    private String fileName;
    @Resource
    private RepositoryUtil repositoryUtil;

    @Override
    public boolean singleImportPersonal(Personal personal) {
        return repositoryUtil.save(personalRepository, personal);
    }

    @Override
    public boolean batchImportPersonals(MultipartFile file) {
        try {
            List<Personal> personals = EasyExcel.read(file.getInputStream())
                    .head(Personal.class)
                    .sheet()
                    .doReadSync();
            for (Personal personal : personals) {
                if (personal.getSuperior() != null) {
                    String superiorName = personal.getSuperior().getName();
                    Personal superior = personalRepository.findPersonalByName(superiorName);
                    personal.setSuperior(superior);
                }
                if (personal.getDepartment() != null) {
                    String departmentName = personal.getDepartment().getDepartmentName();
                    Department department = departmentRepository.findDepartmentByDepartmentName(departmentName);
                    personal.setDepartment(department);
                }
                if (personal.getPosition() != null) {
                    String positionName = personal.getPosition().getPositionName();
                    Position position = positionRepository.findPositionsByPositionName(positionName);
                    personal.setPosition(position);
                }
                if (!repositoryUtil.save(personalRepository, personal)) {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ResponseEntity<byte[]> getBatchImportPersonalsTemple() {
        String filePath = request.getServletContext().getRealPath(fileName);
        File file = null;
        try {
            file = new ClassPathResource(fileName).getFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileUtil.getResponseEntity(file);
    }
}
