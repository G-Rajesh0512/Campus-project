package com.Admin.controller;

import com.Admin.model.AdminEntity;
import com.Admin.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/loginform")
    public String loginForm() {
        return "forward:/login.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session) {
        Optional<AdminEntity> optionalAdmin = adminService.getAdminByEmail(email);

        if (optionalAdmin.isPresent()) {
            AdminEntity admin = optionalAdmin.get();

            if (admin.getPassword().trim().equals(password.trim())) {
                session.setAttribute("adminEmail", email);
                adminService.updateLoginTime(admin);
                return "/header_nav.html";
            }
        }
        return "Invalid username or password. Please try again.";
    }


    @PostMapping("/logout")
    public String logout(HttpSession session) {
        String email = (String) session.getAttribute("adminEmail");
        if (email != null) {
            adminService.getAdminByEmail(email).ifPresent(adminService::updateLogoutTime);
        }
        session.invalidate();
        return "redirect:/login.html"; 
    }

    @PostMapping("/create")
    public AdminEntity createAdmin(@RequestBody AdminEntity admin) {
        admin.setCreatedAt(LocalDateTime.now());
        return adminService.createAdmin(admin);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<AdminEntity> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/profile")
    @ResponseBody
    public AdminEntity getProfile(HttpSession session) {
        String email = (String) session.getAttribute("adminEmail");
        return adminService.getAdminByEmail(email)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }
}
