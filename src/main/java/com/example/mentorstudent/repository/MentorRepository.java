package com.example.mentorstudent.repository;

import com.example.mentorstudent.models.entity.Admin;
import com.example.mentorstudent.models.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {
    Mentor findOneByEmail(String email);

    Boolean existsByEmail(String email);
}
