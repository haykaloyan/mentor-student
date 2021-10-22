package com.example.mentorstudent.models.dto;

import com.example.mentorstudent.models.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class UserDto {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private int userRoleId;
    private UserRole userRole;


}
