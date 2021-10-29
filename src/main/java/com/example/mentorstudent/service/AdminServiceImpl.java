package com.example.mentorstudent.service;

import com.example.mentorstudent.exeption.ResourceNotFoundException;
import com.example.mentorstudent.mapper.MentorMapper;
import com.example.mentorstudent.mapper.StudentMapper;
import com.example.mentorstudent.models.dto.MentorStudentDto;
import com.example.mentorstudent.models.entity.*;
import com.example.mentorstudent.repository.AdminRepository;
import com.example.mentorstudent.repository.MentorRepository;
import com.example.mentorstudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final MentorRepository mentorRepository;
    private final MentorMapper mentorMapper;
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, MentorRepository mentorRepository,
                            MentorMapper mentorMapper, StudentMapper studentMapper,
                            StudentRepository studentRepository) {
        this.adminRepository = adminRepository;
        this.mentorRepository = mentorRepository;
        this.mentorMapper = mentorMapper;
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    @Override
    public MentorStudentDto getAllUser() {
        MentorStudentDto mentorStudentDto = new MentorStudentDto();

        mentorStudentDto.setMentors(mentorRepository.findAll()
                .stream()
                .map(mentorMapper::toDto)
                .collect(Collectors.toList()));

        mentorStudentDto.setStudents(
                studentRepository.findAll()
                        .stream()
                        .map(studentMapper::toDto)
                        .collect(Collectors.toList()));
        return mentorStudentDto;
    }

    public String userLevel(String email, UserRole userRole) {
        User user = findUser(email);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }

        switch (userRole.name()) {
            case "ADMIN_ROLE":
                adminRepository.save((Admin) userTo(new Admin(), user, UserRole.ADMIN_ROLE));
                break;
            case "MENTOR_ROLE":
                mentorRepository.save((Mentor) userTo(new Mentor(), user, UserRole.MENTOR_ROLE));
                break;
            case "STUDENT_ROLE":
                studentRepository.save((Student) userTo(new Student(), user, UserRole.STUDENT_ROLE));
                break;
        }

        return "Role Changed";
    }

    private User userTo(User user, User dataBaseUser, UserRole userRole) {
        user.setName(dataBaseUser.getName());
        user.setSurname(dataBaseUser.getSurname());
        user.setEmail(dataBaseUser.getEmail());
        user.setPassword(dataBaseUser.getPassword());
        user.setUserRoleId(userRole.ordinal());
        user.setUserRole(userRole);
        return user;
    }

    private User findUser(String email) {
        User user;
        if (studentRepository.existsByEmail(email)) {
            user = studentRepository.findOneByEmail(email);
            studentRepository.deleteById(user.getId());
            return user;
        } else if (mentorRepository.existsByEmail(email)) {
            user = mentorRepository.findOneByEmail(email);
            mentorRepository.deleteById(user.getId());
            return user;
        } else if (adminRepository.existsByEmail(email)) {
            user = adminRepository.findOneByEmail(email);
            adminRepository.deleteById(user.getId());
            return user;

        }
        return null;
    }


}
