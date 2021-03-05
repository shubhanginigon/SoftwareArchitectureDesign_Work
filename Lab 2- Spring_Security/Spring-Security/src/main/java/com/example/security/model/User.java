package com.example.security.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {
	
	@Id //primary key
	//Auto incremented value
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	//Cannot be null
	@Column(nullable = false)
	@NotBlank(message = "This field is required")
	private String username;
	
	@Column(nullable = false)
	@NotBlank(message = "This field is required") //validation dependency
	private String password;
	
	@NotBlank(message = "This field is required")
	@Transient // do not put this field in table
	private String passwordConfirm;
	
	@Column(nullable = false)
	@NotBlank(message = "This field is required")
	@Email(message="Invalid email")
	private String email;
	
	private boolean active;
	
	//Many to Many relationship btw user and role 
	//ManyToMany creates a intermediate table 
	//If spring security it will automatically mandate the fetch type eager
	@ManyToMany(fetch = FetchType.EAGER) //it creates the table with column User_id , Role_id and can be renamed using  @JoinTable
	//In many to Many we need to specify the parent and child relationship 
	@JsonBackReference
	private Set<Role> roles;

}
