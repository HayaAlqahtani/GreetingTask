package com.fursah.BankSystem.controller;

import com.fursah.BankSystem.entity.UserEntity;
import com.fursah.BankSystem.service.admin.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/get_users")
    public List<UserEntity> getAllUsers() {
        return adminService.getAllUsers();
    }

}
