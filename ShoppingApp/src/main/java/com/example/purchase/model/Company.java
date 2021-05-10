package com.example.purchase.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@Column(nullable = false)
    private String name;
	
	@OneToMany(mappedBy = "company")
	private Set<Product> products;

}
