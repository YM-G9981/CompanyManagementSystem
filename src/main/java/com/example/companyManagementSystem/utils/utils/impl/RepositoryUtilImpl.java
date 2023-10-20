package com.example.companyManagementSystem.utils.utils.impl;

import com.example.companyManagementSystem.utils.utils.RepositoryUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Configuration
public class RepositoryUtilImpl<T> implements RepositoryUtil<T> {
    @Override
    public boolean save(JpaRepository<T, Long> repository, T object) {
        try {
            object=  repository.save(object);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean saveAll(JpaRepository<T, Long> repository, List<T> objects) {
        try {
            repository.saveAll(objects);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(JpaRepository<T, Long> repository, T object) {
        try {
            repository.delete(object);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAllById(JpaRepository<T, Long> repository, List<Long> objectIds) {
        try {
            repository.deleteAllById(objectIds);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(JpaRepository<T, Long> repository, long objectId) {
        try {
            repository.deleteById(objectId);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
