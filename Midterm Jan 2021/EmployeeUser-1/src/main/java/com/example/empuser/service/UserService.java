package com.example.empuser.service;

import com.example.empuser.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}