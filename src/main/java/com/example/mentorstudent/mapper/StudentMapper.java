package com.example.mentorstudent.mapper;

import com.example.mentorstudent.models.dto.StudentDto;
import com.example.mentorstudent.models.entity.Student;
import com.example.mentorstudent.models.entity.UserRole;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDto toDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setSurname(student.getSurname());
        studentDto.setEmail(student.getEmail());
        studentDto.setUserRoleId(student.getUserRoleId());
        studentDto.setUserRole(UserRole.STUDENT_ROLE);
        return studentDto;
    }

    public Student toEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setEmail(studentDto.getEmail());
        student.setPassword(studentDto.getPassword());
        student.setUserRoleId(studentDto.getUserRoleId());
        student.setUserRole(UserRole.STUDENT_ROLE);
        return student;
    }
}
