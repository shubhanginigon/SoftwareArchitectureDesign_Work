package com.example.locking;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.locking.service.ProductService;

@SpringBootApplication
public class OptimisticLockingApplication1 {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ConfigurableApplicationContext applicationContext = 
				SpringApplication.run(OptimisticLockingApplication1.class, args);
		ProductService ps = applicationContext.getBean(ProductService.class);
		
		ps.createMockProduct();
		ps.writeLockTransaction();//the write lock will block the read block
		ps.readLockTransaction();
   
	}
	
	

}
