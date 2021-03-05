package com.example.designPattern.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.designPattern.model.User;

@RestController
@RequestMapping("/builder")
public class BuilderController {
	
	@GetMapping("userAuto")
	public String getUser() {
		User u = User.builder()
				.email("New@example.com")
				.name("New User")
				.nationality("Indian")
				.uid(101)
				.build();
		System.out.println(u.toString());
		return "created";
	}
}
