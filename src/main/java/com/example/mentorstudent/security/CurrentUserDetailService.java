package com.example.mentorstudent.security;

import com.example.mentorstudent.models.entity.User;
import com.example.mentorstudent.models.entity.UserRole;
import com.example.mentorstudent.repository.AdminRepository;
import com.example.mentorstudent.repository.MentorRepository;
import com.example.mentorstudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailService implements UserDetailsService {
    @Autowired
    private MentorRepository mentorRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = null;
        if (adminRepository.existsByEmail(email)) {
            user = adminRepository.findOneByEmail(email);
            user.setUserRole(UserRole.ADMIN_ROLE);
        } else if (mentorRepository.existsByEmail(email)) {
            user = mentorRepository.findOneByEmail(email);
            user.setUserRole(UserRole.MENTOR_ROLE);
        } else if (studentRepository.existsByEmail(email)) {
            user = studentRepository.findOneByEmail(email);
            user.setUserRole(UserRole.STUDENT_ROLE);

        }
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User the email %s not found", email));
        }
        return new CurrentUser(user);
    }
}
