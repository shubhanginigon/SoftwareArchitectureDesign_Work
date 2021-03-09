package com.example.empuser.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.empuser.model.Role;

public interface RoleJPADao extends JpaRepository<Role, Integer> {

}