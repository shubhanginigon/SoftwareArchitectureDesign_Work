package com.example.purchase.controller;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.purchase.model.Product;
import com.example.purchase.service.ProductService;

@Controller
public class ProductCon {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/list")
    public String showUserProductList(ModelMap model, Principal principal ) {
		
		
		List<Product> products = productService.findAll(); 
        model.addAttribute("products", products);
        return "home.jsp";
    }

}
