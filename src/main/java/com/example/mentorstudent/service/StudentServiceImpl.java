package com.example.mentorstudent.service;

import com.example.mentorstudent.mapper.StudentMapper;
import com.example.mentorstudent.models.dto.StudentDto;
import com.example.mentorstudent.models.entity.Student;
import com.example.mentorstudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentDto updateStudentById(int id, StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        student.setId(id);
        return studentMapper.toDto(studentRepository.save(student));
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        Student save = studentRepository.save(studentMapper.toEntity(studentDto));
        return studentMapper.toDto(save);
    }

    @Override
    public void deleteStudent(StudentDto studentDto) {
        studentRepository.deleteById(studentDto.getId());
    }

//    @Override
//    public StudentDto addStudent(StudentDto studentDto) {
//        studentDto.setUserRoleId(UserRole.STUDENT_ROLE.ordinal());
//        Student save = studentRepository.save(studentMapper.toEntity(studentDto));
//        return studentMapper.toDto(save);
//    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(int id) {
        return studentMapper.toDto(studentRepository.getById(id));

    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
}
