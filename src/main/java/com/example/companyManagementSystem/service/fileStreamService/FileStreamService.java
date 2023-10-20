package com.example.companyManagementSystem.service.fileStreamService;

import com.example.companyManagementSystem.entity.fileStream.FileStream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileStreamService {
    boolean save(FileStream fileStream);
    List<FileStream> getFileStreamsByPersonal(Long personalId);
    List<FileStream> getFileStreamsByPersonalList(Long personalId);
    List<FileStream> getFileStreamsBySubject(String subject);
    List<FileStream> getFileStreamsByFileStreamId(long streamId);
    boolean delFileStream(List<Long> fileStreamIds);

    boolean delFile(long fileId);

    boolean saveMultipartFile(MultipartFile multipartFile, long fileStreamId, String fileName);

    List<FileStream> getAllFileStream();

    ResponseEntity<byte[]> getFile(long fileId);
}
