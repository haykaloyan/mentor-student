package com.example.mentorstudent.mapper;

import com.example.mentorstudent.models.dto.MentorDto;
import com.example.mentorstudent.models.entity.Mentor;
import com.example.mentorstudent.models.entity.UserRole;
import org.springframework.stereotype.Component;

@Component
public class MentorMapper {
    public MentorDto toDto(Mentor mentor) {
        MentorDto mentorDto = new MentorDto();
        mentorDto.setId(mentor.getId());
        mentorDto.setName(mentor.getName());
        mentorDto.setSurname(mentor.getName());
        mentorDto.setEmail(mentor.getEmail());
        mentorDto.setUserRoleId(mentor.getUserRoleId());
        mentorDto.setUserRole(UserRole.MENTOR_ROLE);
        return mentorDto;
    }

    public Mentor toEntity(MentorDto mentorDto) {
        Mentor mentor = new Mentor();
        mentor.setId(mentorDto.getId());
        mentor.setName(mentorDto.getName());
        mentor.setSurname(mentorDto.getName());
        mentor.setEmail(mentorDto.getEmail());
        mentor.setUserRoleId(mentorDto.getUserRoleId());
        mentor.setUserRole(UserRole.MENTOR_ROLE);
        return mentor;
    }
}
