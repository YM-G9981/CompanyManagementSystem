package com.example.companyManagementSystem.controller.fileStreamController.impl;

import com.example.companyManagementSystem.controller.fileStreamController.FileStreamController;
import com.example.companyManagementSystem.entity.fileStream.FileStream;
import com.example.companyManagementSystem.service.fileStreamService.FileStreamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/fileStream")
public class FileStreamControllerImpl implements FileStreamController {
    @Resource
    private FileStreamService fileStreamService;
    @PostMapping("/save")
    @Override
    public boolean save(FileStream fileStream) {
        return false;
    }
    @PostMapping("/getFileStreamsByPersonal/{personalId}")
    @Override
    public List<FileStream> getFileStreamsByPersonal(@PathVariable Long personalId) {
        return fileStreamService.getFileStreamsByPersonal(personalId);
    }
    @PostMapping("/getFileStreamsByPersonalList/{personalId}")
    @Override
    public List<FileStream> getFileStreamsByPersonalList(@PathVariable Long personalId) {
        return fileStreamService.getFileStreamsByPersonalList(personalId);
    }
    @PostMapping("/getFileStreamsBySubject/{subject}")
    @Override
    public List<FileStream> getFileStreamsBySubject(@PathVariable String subject) {
        return fileStreamService.getFileStreamsBySubject(subject);
    }
    @PostMapping("/getAllFileStream")
    @Override
    public List<FileStream> getAllStream() {
        return fileStreamService.getAllFileStream();
    }

    @PostMapping("/getFileStreamsByFileStreamId/{streamId}")
    @Override
    public List<FileStream> getFileStreamsByFileStreamId(@PathVariable long streamId) {
        return fileStreamService.getFileStreamsByFileStreamId(streamId);
    }

    @PostMapping("/delFileStream")
    @Override
    public boolean delFileStream(@RequestBody List<Long> fileStreamIds) {
        return fileStreamService.delFileStream(fileStreamIds);
    }
    @PostMapping("/saveMultipartFile/{fileStreamId}/{fileName}")
    @Override
    public boolean saveMultipartFile(@RequestBody MultipartFile multipartFile,@PathVariable long fileStreamId, @PathVariable String fileName) {
        return fileStreamService.saveMultipartFile(multipartFile,fileStreamId,fileName);
    }
    @PostMapping("/delFile/{fileId}")
    @Override
    public boolean delFile(@PathVariable long fileId) {
        return fileStreamService.delFile(fileId);
    }
    @PostMapping("/getFile/{fileId}")
    @Override
    public ResponseEntity<byte[]> getFile(@PathVariable long fileId) {
        return fileStreamService.getFile(fileId);
    }
}
