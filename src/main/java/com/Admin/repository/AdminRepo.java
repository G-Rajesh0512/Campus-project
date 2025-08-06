package com.Admin.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Admin.model.AdminEntity;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity, Long> {
    Optional<AdminEntity> findByEmailAndPassword(String email, String password);
    Optional<AdminEntity> findByEmail(String email);

}
