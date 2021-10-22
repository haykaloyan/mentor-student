package com.example.mentorstudent.controller;

import com.example.mentorstudent.models.dto.StudentDto;
import com.example.mentorstudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PutMapping("/student")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentService.updateStudent(studentDto));
    }

    @DeleteMapping("/student")
    public ResponseEntity<HttpStatus> deleteStudent(@RequestBody StudentDto studentDto) {
        studentService.deleteStudent(studentDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
