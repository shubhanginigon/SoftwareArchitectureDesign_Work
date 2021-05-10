package com.example.purchase.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(nullable = false)
    private String name;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    @OneToMany(fetch = FetchType.LAZY,mappedBy="product")
    private List<Category> categories;
    
    @Column(name="price", precision=10, scale=2)
    private BigDecimal price_;
    
    @Transient
    private MonetaryAmount price;
    
    @Transient
    private String currencyCode = Contract.CURRENCY.getCurrencyCode();
    
    private int stock;
    
    @PrePersist
    protected void onPrePersist() {
        currencyCode = price.getCurrency().getCurrencyCode();
        price_ = price.getNumber()
                .numberValue(BigDecimal.class)
                .setScale(price.getCurrency().getDefaultFractionDigits(),
                        RoundingMode.HALF_EVEN);
    }

    @PostLoad
    protected void onPostLoad() {
        this.price =
                Monetary.getDefaultAmountFactory()
                        .setNumber(price_)
                        .setCurrency(currencyCode)
                        .create();
    }

}