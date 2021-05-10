package com.example.purchase.model;

import lombok.Getter;
import lombok.ToString;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmountFactory;
import javax.persistence.*;

@Getter
@Entity
@ToString
public class Contract {

    //JPA will not persist any static final field
    public static final CurrencyUnit CURRENCY = Monetary.getCurrency("USD");

    @Transient
    private MonetaryAmountFactory<?> amountFactory = Monetary.getDefaultAmountFactory();

    @Transient
    private String currencyCode = CURRENCY.getCurrencyCode();

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    protected Contract() { /* as needed by JPA/ORM */ }

}
