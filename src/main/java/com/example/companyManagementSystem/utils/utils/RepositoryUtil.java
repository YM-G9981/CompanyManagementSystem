package com.example.companyManagementSystem.utils.utils;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryUtil<T> {
    boolean save(JpaRepository<T, Long> repository, T object);

    boolean saveAll(JpaRepository<T, Long> repository, List<T> objects);

    boolean delete(JpaRepository<T, Long> repository, T object);

    boolean deleteAllById(JpaRepository<T, Long> repository, List<Long> objectIds);

    boolean deleteById(JpaRepository<T, Long> repository, long objectId);
}
