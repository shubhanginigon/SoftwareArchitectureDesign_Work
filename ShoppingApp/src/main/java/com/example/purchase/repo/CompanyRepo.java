package com.example.purchase.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.purchase.model.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer>{

}
