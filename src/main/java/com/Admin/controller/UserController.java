package com.Admin.controller;

import com.Admin.model.AdminEntity;
import com.Admin.model.UserEntity;
import com.Admin.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    private boolean isAuthenticated(HttpSession session) {
        return session.getAttribute("adminEmail") != null;
    }

    @GetMapping("/assigned")
    public ResponseEntity<?> getAssignedUsers(HttpSession session) {
        String email = (String) session.getAttribute("adminEmail");
        if (email == null) return ResponseEntity.status(401).body("Unauthorized");

        List<UserEntity> users = userService.getUsersByAdminEmail(email);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserEntity user, HttpSession session) {
        String email = (String) session.getAttribute("adminEmail");
        if (email == null) return ResponseEntity.status(401).body("Unauthorized");

        AdminEntity admin = userService.getAdminByEmail(email);
        user.setAdmin(admin);
        UserEntity saved = userService.saveUser(user);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserEntity user, HttpSession session) {
        if (!isAuthenticated(session)) return ResponseEntity.status(401).body("Unauthorized");
        user.setId(id);
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id, HttpSession session) {
        if (!isAuthenticated(session)) return ResponseEntity.status(401).body("Unauthorized");
        userService.deleteUser(id);
        return ResponseEntity.ok("Deleted");
    }
}
