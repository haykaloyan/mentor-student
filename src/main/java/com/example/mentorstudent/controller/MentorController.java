package com.example.mentorstudent.controller;

import com.example.mentorstudent.models.dto.StudentDto;
import com.example.mentorstudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mentor")
public class MentorController {

    @Autowired
    private StudentService studentService;

//    @PostMapping("/student")
//    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
//        return ResponseEntity.ok(studentService.addStudent(studentDto));
//    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<HttpStatus> deleteStudentById(@PathVariable(name = "id") int id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PutMapping("/student/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable(name = "id") int id, @RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentService.updateStudentById(id, studentDto));
    }
}
