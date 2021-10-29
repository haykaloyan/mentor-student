package com.example.mentorstudent.repository;

import com.example.mentorstudent.models.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository  extends JpaRepository<Admin, Integer> {
    Boolean existsByEmail(String email);

    Admin findOneByEmail(String email);

}
