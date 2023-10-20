package com.example.companyManagementSystem.service.fileStreamService.impl;

import com.example.companyManagementSystem.entity.fileStream.FileStream;
import com.example.companyManagementSystem.repository.fileStreamRepository.FileStreamAppendixFileRepository;
import com.example.companyManagementSystem.repository.fileStreamRepository.FileStreamRepository;
import com.example.companyManagementSystem.service.fileStreamService.FileStreamService;
import com.example.companyManagementSystem.utils.utils.FileUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
@Service
public class FileStreamServiceImpl implements FileStreamService {
    @Resource
    private FileStreamRepository fileStreamRepository;
    @Resource
    private FileStreamAppendixFileRepository fileStreamAppendixFileRepository;
    @Resource
    private  FileUtil fileUtil;
    @Override
    public boolean save(FileStream fileStream) {
        try {
            fileStreamRepository.save(fileStream);
        }catch (Exception e){
            return false;
        }
        return  true;
    }

    @Override
    public List<FileStream> getFileStreamsByPersonal(Long personalId)
    {
        return fileStreamRepository.findAllByPersonal_PersonalId(personalId);
    }

    @Override
    public List<FileStream> getFileStreamsByPersonalList(Long personalId) {
        return fileStreamRepository.findAllByPersonalsContaining(personalId);
    }

    @Override
    public List<FileStream> getFileStreamsBySubject(String subject)
    {
        return fileStreamRepository.findAllByFileStreamSubjectLike("%"+subject+"%");
    }

    @Override
    public List<FileStream> getFileStreamsByFileStreamId(long streamId) {
        return fileStreamRepository.findAllByFileStreamId(streamId);
    }

    @Override
    public boolean delFileStream(List<Long> fileStreamIds) {
        try {
             fileStreamRepository.deleteAllById(fileStreamIds);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean delFile(long fileId) {
        return false;
    }

    @Override
    public boolean saveMultipartFile(MultipartFile multipartFile, long fileStreamId, String fileName) {
        return false;
    }

    @Override
    public List<FileStream> getAllFileStream() {
        return fileStreamRepository.findAll();
    }

    @Override
    public ResponseEntity<byte[]> getFile(long fileId) {
        File file = fileStreamAppendixFileRepository.findFileStreamAppendixFileByFileId(fileId).getFile();
        return fileUtil.getResponseEntity(file);
    }
}
