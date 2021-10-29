package com.example.mentorstudent.controller;

import com.example.mentorstudent.models.dto.StudentDto;
import com.example.mentorstudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mentors")
public class MentorController {

    private final StudentService studentService;

    @Autowired
    public MentorController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudentById(@PathVariable(name = "id") int id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PutMapping("/student/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable(name = "id") int id, @RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentService.updateStudentById(id, studentDto));
    }
}
