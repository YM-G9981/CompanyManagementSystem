package com.example.companyManagementSystem.repository.fileStreamRepository;

import com.example.companyManagementSystem.entity.fileStream.FileStreamAppendixFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileStreamAppendixFileRepository extends JpaRepository<FileStreamAppendixFile,Long> {
    FileStreamAppendixFile findFileStreamAppendixFileByFileId(long fileId);
}
