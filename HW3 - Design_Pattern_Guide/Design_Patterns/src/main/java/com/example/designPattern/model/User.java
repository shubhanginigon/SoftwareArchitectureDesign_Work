package com.example.designPattern.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class User {
	
	@Id
	private int uid;
	private String name;
	private String nationality;
	private String email;

}
