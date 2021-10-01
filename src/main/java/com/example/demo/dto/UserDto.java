package com.example.demo.dto;

import com.example.demo.model.User;

public class UserDto{
    private String username;
    private String password;
    private String name;

    public User getUserFromDto(){
        User user = new User();

        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setName(this.name);

        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDto(String name, String username, String password) {
        super();
        this.name = name;
        this.username = username;
        this.password = password;
    }
}