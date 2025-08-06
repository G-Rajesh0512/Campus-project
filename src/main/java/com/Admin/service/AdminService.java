package com.Admin.service;

import com.Admin.model.AdminEntity;
import com.Admin.repository.AdminRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public Optional<AdminEntity> validateLogin(String email, String password) {
        return adminRepo.findByEmailAndPassword(email, password);
    }
    public AdminEntity createAdmin(AdminEntity admin) {
        return adminRepo.save(admin);
    }

    public List<AdminEntity> getAllAdmins() {
        return adminRepo.findAll();
    }


    public Optional<AdminEntity> getAdminByEmail(String email) {
        return adminRepo.findByEmail(email);
    }

    public void updateLoginTime(AdminEntity admin) {
        admin.setLastLogin(LocalDateTime.now());
        adminRepo.save(admin);
    }

    public void updateLogoutTime(AdminEntity admin) {
        admin.setLastPasswordChange(LocalDateTime.now());
        adminRepo.save(admin);
    }
}
