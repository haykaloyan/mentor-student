package com.example.mentorstudent.service;

import com.example.mentorstudent.models.dto.StudentDto;
import com.example.mentorstudent.models.entity.Student;

import java.util.List;

public interface StudentService {
    StudentDto updateStudentById(int id, StudentDto studentDto);

    StudentDto updateStudent(StudentDto studentDto);

    void deleteStudent(StudentDto studentDto);

    //    StudentDto addStudent (StudentDto studentDto);
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(int id);

    void deleteStudentById(int id);

}
