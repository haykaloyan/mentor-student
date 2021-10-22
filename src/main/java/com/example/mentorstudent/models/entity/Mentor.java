package com.example.mentorstudent.models.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mentors")
public class Mentor extends User{
}
