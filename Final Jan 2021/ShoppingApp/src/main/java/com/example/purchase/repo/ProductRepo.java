package com.example.purchase.repo;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.purchase.model.Product;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	List<Product> findAll();
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select p from Product p where p.id = :id")
	Product findProductForWrite(@Param("id") Long id);
	
	@Lock(LockModeType.PESSIMISTIC_READ)
	@Query("select p from Product p where p.id = :id")
	Product findProductForRead(@Param("id") Long id);
}
