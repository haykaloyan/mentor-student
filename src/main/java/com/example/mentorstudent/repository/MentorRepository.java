package com.example.mentorstudent.repository;

import com.example.mentorstudent.models.dto.MentorDto;
import com.example.mentorstudent.models.entity.Admin;
import com.example.mentorstudent.models.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {
    Mentor findOneByEmail(String email);
Optional<Mentor> findById (int id);
    Boolean existsByEmail(String email);
}
