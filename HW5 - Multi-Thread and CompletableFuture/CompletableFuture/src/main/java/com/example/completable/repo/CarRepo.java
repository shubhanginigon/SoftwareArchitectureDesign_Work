package com.example.completable.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.completable.model.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {

}
