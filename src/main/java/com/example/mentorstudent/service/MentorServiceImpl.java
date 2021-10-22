package com.example.mentorstudent.service;

import com.example.mentorstudent.mapper.MentorMapper;
import com.example.mentorstudent.mapper.StudentMapper;
import com.example.mentorstudent.models.dto.MentorDto;
import com.example.mentorstudent.models.entity.Mentor;
import com.example.mentorstudent.models.entity.UserRole;
import com.example.mentorstudent.repository.AdminRepository;
import com.example.mentorstudent.repository.MentorRepository;
import com.example.mentorstudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;
    @Autowired
    private MentorMapper mentorMapper;


    //    @Override
//    public MentorDto addMentor(MentorDto mentorDto) {
//        mentorDto.setUserRoleId(UserRole.MENTOR_ROLE.ordinal());
//        Mentor save = mentorRepository.save(mentorMapper.toEntity(mentorDto));
//        return mentorMapper.toDto(save);
//
//    }
    @Override
    public List<MentorDto> getAllMentors() {
        return mentorRepository.findAll()
                .stream()
                .map(mentorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MentorDto getMentorById(int id) {
        return mentorMapper.toDto(mentorRepository.getById(id));
    }


    @Override
    public void deleteMentorById(int id) {
        mentorRepository.deleteById(id);
    }

    @Override
    public MentorDto updateMentorById(int id, MentorDto mentorDto) {
        Mentor mentor = mentorMapper.toEntity(mentorDto);
        mentor.setId(id);
        return mentorMapper.toDto(mentorRepository.save(mentor));
    }

}
