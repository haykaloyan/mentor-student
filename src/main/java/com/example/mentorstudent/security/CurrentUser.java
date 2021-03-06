package com.example.mentorstudent.security;

import com.example.mentorstudent.models.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserRole().name()));
        this.user = user;

    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return user.getId();
    }
}
