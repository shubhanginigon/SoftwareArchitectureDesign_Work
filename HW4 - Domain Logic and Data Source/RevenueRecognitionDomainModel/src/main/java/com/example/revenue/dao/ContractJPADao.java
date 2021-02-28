package com.example.revenue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.revenue.model.Contract;

public interface ContractJPADao extends JpaRepository<Contract, Integer> {

}
