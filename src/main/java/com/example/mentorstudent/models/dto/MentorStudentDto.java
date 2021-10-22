package com.example.mentorstudent.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentorStudentDto {
    private List<MentorDto> mentors;
    private List<StudentDto> students;
}
