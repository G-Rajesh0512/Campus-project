package com.Admin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Admin.model.LogoutEntity;

@Repository
public interface LogoutRepo extends JpaRepository<LogoutEntity, Long> {
}

