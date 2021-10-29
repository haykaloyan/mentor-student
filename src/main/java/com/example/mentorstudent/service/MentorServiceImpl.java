package com.example.mentorstudent.service;

import com.example.mentorstudent.exeption.ResourceNotFoundException;
import com.example.mentorstudent.mapper.MentorMapper;
import com.example.mentorstudent.mapper.StudentMapper;
import com.example.mentorstudent.models.dto.MentorDto;
import com.example.mentorstudent.models.entity.Mentor;
import com.example.mentorstudent.models.entity.UserRole;
import com.example.mentorstudent.repository.AdminRepository;
import com.example.mentorstudent.repository.MentorRepository;
import com.example.mentorstudent.repository.StudentRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentorServiceImpl implements MentorService {
    private final String NOT_FOUND = UserRole.MENTOR_ROLE.name() + " not found.";

    private final MentorRepository mentorRepository;
    private final MentorMapper mentorMapper;

    @Autowired
    public MentorServiceImpl(MentorRepository mentorRepository, MentorMapper mentorMapper) {
        this.mentorRepository = mentorRepository;
        this.mentorMapper = mentorMapper;
    }

    @Override
    public List<MentorDto> getAllMentors() {
        return mentorRepository.findAll()
                .stream()
                .map(mentorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MentorDto getMentorById(int id) {
        Mentor mentor = mentorRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException(NOT_FOUND));
        return mentorMapper.toDto(mentor);
    }


    @Override
    public void deleteMentorById(int id) {
      mentorRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException(NOT_FOUND));
      mentorRepository.deleteById(id);
    }

    @Override
    public MentorDto updateMentorById(int id, MentorDto mentorDto) {
        mentorRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException(NOT_FOUND));
        Mentor mentor = mentorMapper.toEntity(mentorDto);
        mentor.setId(id);
        return mentorMapper.toDto(mentorRepository.save(mentor));
    }

}
