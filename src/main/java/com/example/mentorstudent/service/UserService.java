package com.example.mentorstudent.service;

import com.example.mentorstudent.models.dto.AuthenticationRequest;
import com.example.mentorstudent.models.dto.AuthenticationResponse;
import com.example.mentorstudent.models.dto.StudentDto;
import com.example.mentorstudent.models.dto.UserDto;
import org.apache.catalina.webresources.AbstractArchiveResource;

public interface UserService {
    StudentDto register(StudentDto studentDto);

    AuthenticationResponse login(AuthenticationRequest authenticationRequest);

}
