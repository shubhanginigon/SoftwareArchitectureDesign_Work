package com.example.purchase.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.purchase.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
