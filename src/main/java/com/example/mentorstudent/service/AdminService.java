package com.example.mentorstudent.service;

import com.example.mentorstudent.models.dto.MentorStudentDto;
import com.example.mentorstudent.models.dto.StudentDto;
import com.example.mentorstudent.models.dto.UserDto;
import com.example.mentorstudent.models.entity.UserRole;

public interface AdminService {
    MentorStudentDto getAllUser();

    StudentDto userLevel(String email, UserRole userRole);

}
