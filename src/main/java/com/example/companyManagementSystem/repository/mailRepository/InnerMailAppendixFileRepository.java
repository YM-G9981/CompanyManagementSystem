package com.example.companyManagementSystem.repository.mailRepository;

import com.example.companyManagementSystem.entity.mail.innerMail.AppendixFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InnerMailAppendixFileRepository extends JpaRepository<AppendixFile, Long> {
    @Query(value = "select * from inner_mail_appendix_files i where i.mail in (?1) ", nativeQuery = true)
    List<AppendixFile> findAppendixFileByMailId(List<Long> mailIds);

    AppendixFile findAppendixFileByFileId(long fileId);
}
