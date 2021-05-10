package com.example.purchase.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.purchase.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
