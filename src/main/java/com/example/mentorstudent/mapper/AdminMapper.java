package com.example.mentorstudent.mapper;

import com.example.mentorstudent.models.dto.AdminDto;
import com.example.mentorstudent.models.entity.Admin;
import com.example.mentorstudent.models.entity.UserRole;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public AdminDto toDto(Admin admin) {
        AdminDto adminDto = new AdminDto();
        adminDto.setId(admin.getId());
        adminDto.setName(admin.getName());
        adminDto.setSurname(admin.getName());
        adminDto.setEmail(admin.getEmail());
        adminDto.setUserRoleId(admin.getUserRoleId());
        adminDto.setUserRole(UserRole.ADMIN_ROLE);
        return adminDto;
    }

    public Admin toEntity(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setId(adminDto.getId());
        admin.setName(adminDto.getName());
        admin.setSurname(adminDto.getName());
        admin.setEmail(adminDto.getEmail());
        admin.setUserRoleId(adminDto.getUserRoleId());
        return admin;
    }
}
