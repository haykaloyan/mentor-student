package com.example.mentorstudent.service;

import com.example.mentorstudent.models.dto.MentorDto;

import java.util.List;

public interface MentorService {
//    MentorDto addMentor(MentorDto mentorDto);

    List<MentorDto> getAllMentors();

    MentorDto getMentorById(int id);

    void deleteMentorById(int id);

    MentorDto updateMentorById(int id, MentorDto mentorDto);


}
