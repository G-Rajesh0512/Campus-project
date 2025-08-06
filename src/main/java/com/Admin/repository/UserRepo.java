package com.Admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Admin.model.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByAdminEmail(String email); 
}
