package com.Admin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Admin.model.LoginEntity;

@Repository
public interface LoginRepo extends JpaRepository<LoginEntity, Long> {
}

