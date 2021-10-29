package com.example.mentorstudent.repository;

import com.example.mentorstudent.models.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Boolean existsByEmail(String email);

    Student findOneByEmail(String email);

}
