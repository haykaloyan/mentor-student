package com.example.mentorstudent.service;

import com.example.mentorstudent.mapper.AdminMapper;
import com.example.mentorstudent.mapper.MentorMapper;
import com.example.mentorstudent.mapper.StudentMapper;
import com.example.mentorstudent.models.dto.*;
import com.example.mentorstudent.models.entity.*;
import com.example.mentorstudent.repository.AdminRepository;
import com.example.mentorstudent.repository.MentorRepository;
import com.example.mentorstudent.repository.StudentRepository;
import com.example.mentorstudent.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    MentorRepository mentorRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AdminService adminService;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    MentorMapper mentorMapper;


    @Override
    public StudentDto register(StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setUserRoleId(UserRole.STUDENT_ROLE.ordinal());
        student.setUserRole(UserRole.STUDENT_ROLE);
        return studentMapper.toDto(studentRepository.save(student));
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
//        MentorStudentDto allUser = adminService.getAllUser();
//        List<MentorDto> mentors = allUser.getMentors();
//        List<StudentDto> students = allUser.getStudents();

        Admin admin = adminRepository.findOneByEmail(authenticationRequest.getEmail());
        Mentor mentor = mentorRepository.findOneByEmail(authenticationRequest.getEmail());
        Student student = studentRepository.findOneByEmail(authenticationRequest.getEmail());

        if (admin != null && passwordEncoder.matches(authenticationRequest.getPassword(), admin.getPassword())) {
            AdminDto adminDto = adminMapper.toDto(admin);
            String token = jwtTokenUtil.generateToken(admin.getEmail());
            return new AuthenticationResponse(token, adminDto);
        } else if (mentor != null && passwordEncoder.matches(authenticationRequest.getPassword(), mentor.getPassword())) {
            MentorDto mentorDto = mentorMapper.toDto(mentor);
            String token = jwtTokenUtil.generateToken(mentor.getEmail());
            return new AuthenticationResponse(token, mentorDto);
        } else if (student != null && passwordEncoder.matches(authenticationRequest.getPassword(), student.getPassword())) {
            student.setUserRole(UserRole.STUDENT_ROLE);
            StudentDto studentDto = studentMapper.toDto(student);
            String token = jwtTokenUtil.generateToken(student.getEmail());
            return new AuthenticationResponse(token, studentDto);
        }
        return null;

    }

}
