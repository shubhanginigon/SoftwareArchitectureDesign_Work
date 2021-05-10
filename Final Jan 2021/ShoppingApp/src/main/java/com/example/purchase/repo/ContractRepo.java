package com.example.purchase.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.purchase.model.Contract;

public interface ContractRepo extends JpaRepository<Contract, Integer> {
}
