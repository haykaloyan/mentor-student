package com.example.mentorstudent.controller;

import com.example.mentorstudent.models.dto.AuthenticationRequest;
import com.example.mentorstudent.models.dto.AuthenticationResponse;
import com.example.mentorstudent.models.dto.StudentDto;
import com.example.mentorstudent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<StudentDto> userRegister(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(userService.register(studentDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> userLogin(@RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse login = userService.login(authenticationRequest);
        return ResponseEntity.ok(login);
    }
}
