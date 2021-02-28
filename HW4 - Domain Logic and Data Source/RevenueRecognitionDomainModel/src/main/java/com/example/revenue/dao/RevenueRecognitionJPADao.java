package com.example.revenue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.revenue.model.RevenueRecognition;

public interface RevenueRecognitionJPADao extends JpaRepository<RevenueRecognition, Integer> {

}
