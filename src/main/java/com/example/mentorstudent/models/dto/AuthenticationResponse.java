package com.example.mentorstudent.models.dto;

public class AuthenticationResponse {
    public AuthenticationResponse(String token, UserDto userDto) {
        this.token = token;
        this.userDto = userDto;
    }

    public AuthenticationResponse() {
    }

    private String token;
    private UserDto userDto;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
