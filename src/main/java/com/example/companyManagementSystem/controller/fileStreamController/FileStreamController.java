package com.example.companyManagementSystem.controller.fileStreamController;

import com.example.companyManagementSystem.entity.fileStream.FileStream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileStreamController {
    boolean save(FileStream fileStream);
    List<FileStream> getFileStreamsByPersonal(Long personalId);
    List<FileStream> getFileStreamsByPersonalList(Long personalId);
    List<FileStream> getFileStreamsBySubject(String subject);

    List<FileStream> getAllStream();
    List<FileStream> getFileStreamsByFileStreamId(long streamId);
    boolean delFileStream(List<Long> fileStreamIds);

    boolean saveMultipartFile(MultipartFile multipartFile ,long fileStreamId,String fileName);
    boolean delFile(long fileId);

    ResponseEntity<byte[]> getFile(long fileId);
}
