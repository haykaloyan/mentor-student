package com.example.mentorstudent.repository;

import com.example.mentorstudent.models.entity.Admin;
import com.example.mentorstudent.models.entity.Mentor;
import com.example.mentorstudent.models.entity.User;
import com.example.mentorstudent.models.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Boolean existsByEmail(String email);

    Admin findOneByEmail(String email);

}
