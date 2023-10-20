package com.example.companyManagementSystem.repository.mailRepository;

import com.example.companyManagementSystem.entity.mail.outerMail.AppendixFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OuterMailAppendixFileRepository extends JpaRepository<AppendixFile, Long> {
    AppendixFile findAppendixFileByFileId(long appendixFileId);

    @Query(value = "select * from outer_mail_appendix_files o where o.mail in (?1) ", nativeQuery = true)
    List<AppendixFile> findAppendixFileByMailId(List<Long> mailIds);

    List<AppendixFile> findAppendixFileByFileId(Long fileId);
}
