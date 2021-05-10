package com.example.purchase.service;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.purchase.model.Product;
import com.example.purchase.repo.ProductRepo;


@Service
public class ProductServiceImpl implements ProductService{


	@Autowired
	ProductRepo productRepo;
	
	@Override
	public Product findById(int id) {
		return productRepo.findById(id).orElse(new Product());
	}

	@Override
	public List<Product> findAll() {
		List<Product> products = productRepo.findAll();
		Collections.reverse(products);
		return products;
	}

	@Override
	public void save(Product product) {
		try {
			productRepo.save(product);
		} catch (ObjectOptimisticLockingFailureException e) {
			Product savedProduct = productRepo.findById(product.getProductId()).get();
			if (product.getStock() > savedProduct.getStock()) {
				// If unsuccessful bid is greater than previously updated bid, then try again to save
				System.out.print("Buy again stock amount is changed");
			}
		}
		
		productRepo.save(product);
		
	}
	
	@Transactional
	@Async
	public void readLockTransaction() throws InterruptedException {
			
		System.out.println(LocalTime.now() + " <-- Reading Product entity -->");
		Product product1 = null;
		try {
			product1 = productRepo.findProductForRead(1L);
		} catch (Exception e) {
			System.err
					.println(LocalTime.now() + " -- Got exception while " + 
			"acquiring the read lock:\n " + e + " --");
			return;
		}

		System.out.println(LocalTime.now() + " -- Acquired the read lock --");

		System.out.println(LocalTime.now() + " -- Read product: " + product1 + " --");
		
		Thread.sleep(2000);
	}

	@Transactional
	@Async
	public void writeLockTransaction() throws InterruptedException {
		
		Thread.sleep(100);
		
		System.out.println(LocalTime.now() + " <-- Writing Product entity -->");

		Product product2 = null;
		try {
			product2 = productRepo.findProductForWrite(1L);
		} catch (Exception e) {
			System.err
					.println(LocalTime.now() + " -- Got exception while " + 
			"acquiring the write lock:\n " + e + " --");
			return;
		}

		System.out.println(LocalTime.now() + " -- Acquired write lock --");
		product2.setName("New name");
		productRepo.save(product2);

		System.out.println(LocalTime.now() + " -- User 2 updated product: " + product2 
				+ " --");
	}

	
}
