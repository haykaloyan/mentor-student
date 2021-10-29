package com.example.mentorstudent.controller;

import com.example.mentorstudent.models.dto.*;
import com.example.mentorstudent.service.AdminService;
import com.example.mentorstudent.service.MentorService;
import com.example.mentorstudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {
    private final AdminService adminService;
    private final MentorService mentorService;
    private final StudentService studentService;

    @Autowired
    public AdminController(AdminService adminService, MentorService mentorService, StudentService studentService) {
        this.adminService = adminService;
        this.mentorService = mentorService;
        this.studentService = studentService;
    }




    @GetMapping("/users")
    public ResponseEntity<MentorStudentDto> getAllMentorsAndStudents() {
        return ResponseEntity.ok(adminService.getAllUser());
    }


    @GetMapping("/mentors")
    public ResponseEntity<List<MentorDto>> getAllMentors() {
        return ResponseEntity.ok(mentorService.getAllMentors());
    }

    @GetMapping("/mentors/{id}")
    public ResponseEntity<MentorDto> getMentorById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(mentorService.getMentorById(id));
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @DeleteMapping("/mentors/{id}")
    public ResponseEntity<HttpStatus> deleteMentorById(@PathVariable(name = "id") int id) {
        mentorService.deleteMentorById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudentById(@PathVariable(name = "id") int id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/mentors/{id}")
    public ResponseEntity<MentorDto> updateMentorById(@PathVariable(name = "id") int id, @RequestBody MentorDto mentorDto) {
        return ResponseEntity.ok(mentorService.updateMentorById(id, mentorDto));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable(name = "id") int id, @RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentService.updateStudentById(id, studentDto));
    }

    @PutMapping("/user_level/{email}")
    public ResponseEntity<String> changeUserLevel(@PathVariable(name = "email") String email, @RequestBody StudentDto studentDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(adminService
                        .userLevel(email, studentDto.getUserRole()));
    }

}
