package com.example.purchase.service;

import java.util.List;

import com.example.purchase.model.Product;

public interface ProductService {

	Product findById(int id);

	List<Product> findAll();

	void save(Product product);
}