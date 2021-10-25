package com.example.mentorstudent.service;

import com.example.mentorstudent.models.dto.MentorDto;

import java.util.List;

public interface MentorService {

    List<MentorDto> getAllMentors();

    MentorDto getMentorById(int id);

    void deleteMentorById(int id);

    MentorDto updateMentorById(int id, MentorDto mentorDto);


}
