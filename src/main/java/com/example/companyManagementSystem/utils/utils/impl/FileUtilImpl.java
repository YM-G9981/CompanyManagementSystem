package com.example.companyManagementSystem.utils.utils.impl;

import com.alibaba.excel.EasyExcel;
import com.example.companyManagementSystem.utils.utils.FileUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@Configuration
public class FileUtilImpl implements FileUtil {
    @Resource
    private HttpServletRequest request;

    @Override
    public ResponseEntity<byte[]> getResponseEntity(File file) {
        try {
            FileInputStream inputStream = new FileInputStream(file);
            //输出流
            ByteArrayOutputStream bytOutputStream = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = inputStream.read(b)) != -1) {
                bytOutputStream.write(b, 0, n);
            }
            byte[] bytes = bytOutputStream.toByteArray();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Disposition", "attachment;filename=" + file.getName());
            ResponseEntity<byte[]> entity = new ResponseEntity<>(bytes, headers, HttpStatus.OK);
            return entity;
        } catch (IOException e) {
            return null;
        }
    }
    @Override
    public String getResource(){
        try {
            org.springframework.core.io.Resource resource = new ClassPathResource("");
            return resource.getFile().getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public ResponseEntity<byte[]> getExcelFile(List list, Class daoClass) {
        File file = new File(daoClass.getSimpleName() + "s.xlsx");
        try {
            file.createNewFile();
            EasyExcel.write(new FileOutputStream(file), daoClass)
                    .sheet(daoClass.getName())
                    .doWrite(list);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        ResponseEntity<byte[]> responseEntity = getResponseEntity(file);
        file.delete();
        return responseEntity;
    }

    @Override
    public File saveFile(File file, String path, String fileName) {
        try {
            String parentFileRealPath = path;
            File parentFile = new File(parentFileRealPath);
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            File newFile = new File(parentFileRealPath + "/" + fileName);
            newFile.createNewFile();
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream newFileOutputStream = new FileOutputStream(newFile);
            int i = 0;
            byte[] bs = new byte[1024 * 1024];
            while ((i = fileInputStream.read(bs)) != -1) {
                newFileOutputStream.write(bs);
            }
            newFileOutputStream.flush();
            newFileOutputStream.close();
            fileInputStream.close();
            return newFile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public File saveMultipartFile(MultipartFile file, String path, String fileName) {
        try {
            String parentFileRealPath =path;
            File parentFile = new File(parentFileRealPath);
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            File newFile = new File(parentFileRealPath + "/" + fileName);
            newFile.createNewFile();
            InputStream inputStream = file.getInputStream();
            FileOutputStream newFileOutputStream = new FileOutputStream(newFile);
            int i = 0;
            byte[] bs = new byte[1024 * 1024];
            while ((i = inputStream.read(bs)) != -1) {
                newFileOutputStream.write(bs);
            }
            newFileOutputStream.flush();
            newFileOutputStream.close();
            inputStream.close();
            return newFile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delFile(File file) {
        try {
            if (file.exists()) {
                file.delete();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
