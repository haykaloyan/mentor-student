package com.example.mentorstudent.mapper;

import com.example.mentorstudent.models.dto.AdminDto;
import com.example.mentorstudent.models.dto.UserDto;
import com.example.mentorstudent.models.entity.Admin;
import com.example.mentorstudent.models.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        UserDto userDto = new AdminDto();
        userDto.setName(user.getName());
        userDto.setSurname(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setUserRoleId(user.getUserRoleId());
        return userDto;
    }

    public User toEntity(UserDto userDto) {
        User user = new Admin();
        user.setName(userDto.getName());
        user.setSurname(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setUserRoleId(userDto.getUserRoleId());
        user.setUserRole(userDto.getUserRole());
        return user;
    }
}
