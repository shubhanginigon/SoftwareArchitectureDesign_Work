package com.example.empuser.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Incremented Value
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "This field is required.")
    private String username;

    @NotBlank(message = "This field is required.")
    @Column(nullable = false)
    private String password;
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Employee emp;

	/*
	 * @NotBlank(message = "This field is required.") //in user interface level -
	 * valid email
	 * 
	 * @Email(message = "Enter a valid email") private String email;
	 */
    private boolean active;

    // one user has many roles
    // one role has many roles
    // many to many relationship
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Role> roles;

}