package com.example.companyManagementSystem.repository.fileStreamRepository;

import com.example.companyManagementSystem.entity.fileStream.FileStream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FileStreamRepository extends JpaRepository<FileStream, Long> {
    List<FileStream> findAllByPersonal_PersonalId(long personalId);
    @Query(nativeQuery = true,value = "select * from file_stream f right join file_stream_personal " +
            "fp on f.file_stream_id = fp.file_stream where fp.personal = ?1")
    List<FileStream> findAllByPersonalsContaining(long personalId);

    List<FileStream> findAllByFileStreamSubjectLike(String subject);

    List<FileStream> findAllByFileStreamId(long fileStreamId);
}
