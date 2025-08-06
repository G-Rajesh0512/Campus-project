package com.Admin.service;

import com.Admin.model.AdminEntity;
import com.Admin.model.UserEntity;
import com.Admin.repository.AdminRepo;
import com.Admin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AdminRepo adminRepo;

    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    public List<UserEntity> getUsersByAdminEmail(String email) {
        return userRepo.findByAdminEmail(email);
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepo.findById(id);
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public AdminEntity getAdminByEmail(String email) {
        return adminRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }
}
