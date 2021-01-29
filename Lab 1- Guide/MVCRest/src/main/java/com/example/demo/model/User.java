package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;


//Model is basically a code 
//representation of your db

@Entity 
//letting the spring boot to auto create a db table 
public class User {
	
	@Id
	private int uid;
	private String name;
	private String nationality;
	
	//getters and setters
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	//toString 
		//will be used for returning java 
		//Override
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", nationality=" + nationality + "]";
	}
	

}
