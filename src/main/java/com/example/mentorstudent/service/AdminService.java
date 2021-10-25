package com.example.mentorstudent.service;

import com.example.mentorstudent.models.dto.MentorStudentDto;
import com.example.mentorstudent.models.dto.StudentDto;
import com.example.mentorstudent.models.dto.UserDto;
import com.example.mentorstudent.models.entity.UserRole;
import org.springframework.http.HttpStatus;

public interface AdminService {
    MentorStudentDto getAllUser();

    String userLevel(String email, UserRole userRole);

}
