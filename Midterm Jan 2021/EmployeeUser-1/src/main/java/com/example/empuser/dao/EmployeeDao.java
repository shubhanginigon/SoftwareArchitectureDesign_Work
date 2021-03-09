package com.example.empuser.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.empuser.model.Employee;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    @Query("FROM Employee ORDER BY name")
    List<Employee> getEmployeeSortedByName();
}