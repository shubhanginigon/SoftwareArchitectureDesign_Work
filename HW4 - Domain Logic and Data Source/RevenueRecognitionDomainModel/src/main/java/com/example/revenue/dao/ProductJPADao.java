package com.example.revenue.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.revenue.model.Product;

public interface ProductJPADao extends JpaRepository<Product, Integer>  {

}
