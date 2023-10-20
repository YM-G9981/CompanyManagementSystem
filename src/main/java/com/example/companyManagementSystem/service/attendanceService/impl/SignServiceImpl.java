package com.example.companyManagementSystem.service.attendanceService.impl;

import com.alibaba.excel.EasyExcel;
import com.example.companyManagementSystem.entity.attendance.Sign;
import com.example.companyManagementSystem.entity.hrmResource.User;
import com.example.companyManagementSystem.repository.attendanceRepository.SignRepository;
import com.example.companyManagementSystem.repository.hrmResourceRepository.UserRepository;
import com.example.companyManagementSystem.service.attendanceService.SignService;
import com.example.companyManagementSystem.service.hrmResourceService.impl.ImportDepartmentServiceImpl;
import com.example.companyManagementSystem.utils.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Service
public class SignServiceImpl implements SignService {
    @Resource
    private SignRepository signRepository;
    @Resource
    private UserRepository userRepository;
    @Resource
    private FileUtil fileUtil;
    @Value("${filePath.signPicture}")
    private String filePath;
    @Value("${filePath.importSignsTemple}")
    private String fileName;

    @Override
    public boolean saveSign(Sign sign) {
        boolean b = false;
        try {
            File signPicture = fileUtil.saveFile(sign.getSignPicture(), filePath, sign.getSignId() + "_" + sign.getSignTime().getTime() + ".jpg");
            if (signPicture != null) {
                sign.setSignPicture(signPicture);
            } else {
                return false;
            }
            b = signRepository.save(sign) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return b;
    }

    @Override
    public boolean importSignExcel(MultipartFile multipartFile) {
        try {
            List<Sign> list = EasyExcel.read(multipartFile.getInputStream()).head(Sign.class).sheet().doReadSync();

            for (Sign sign : list) {
                if (sign.getSignUser() != null) {
                    String username = sign.getSignUser().getUsername();
                    User user = userRepository.findUserByUsername(username);
                    sign.setSignUser(user);
                }
                saveSign(sign);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ResponseEntity<byte[]> getBatchImportSignsTemple() {
        String filePath = ImportDepartmentServiceImpl.class.getResource(fileName).getPath();
        File file = new File(filePath);
        return fileUtil.getResponseEntity(file);
    }

}
