package com.example.companyManagementSystem.utils.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface FileUtil {
    ResponseEntity<byte[]> getResponseEntity(File file);

    String getResource();

    ResponseEntity<byte[]> getExcelFile(List list, Class daoClass);

    File saveFile(File file, String path, String fileName);

    File saveMultipartFile(MultipartFile file, String path, String fileName);
    boolean delFile(File file);
}
