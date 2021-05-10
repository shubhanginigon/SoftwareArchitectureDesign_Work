package com.example.purchase.model;

import java.util.List;

import javax.money.MonetaryAmount;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @Column(nullable = false)
    private String name;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    @OneToMany(fetch = FetchType.LAZY,mappedBy="product")
    private List<Category> categories;
    
    @Transient
    private MonetaryAmount price;
    
    @Column(nullable = false)
    private Monetory price;

    private int stock;
}