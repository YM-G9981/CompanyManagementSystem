package com.example.companyManagementSystem.utils.utils;

import org.springframework.context.annotation.Configuration;

@Configuration
public interface LoggerUtil {
    void uncaughtException(Thread t, Throwable ex);

    void catchError(Exception e);
}
