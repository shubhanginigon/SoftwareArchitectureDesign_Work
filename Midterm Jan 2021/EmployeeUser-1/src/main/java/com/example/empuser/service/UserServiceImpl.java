package com.example.empuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.empuser.dao.UserJPADao;
import com.example.empuser.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJPADao userdao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user) {
        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setActive(true);
        userdao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userdao.findByUsername(username);
    }
}