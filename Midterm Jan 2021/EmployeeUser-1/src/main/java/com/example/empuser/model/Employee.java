package com.example.empuser.model;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryAmountFactory;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "employee_info") // alternative table name manually																									// strategy.
public class Employee {

	@Id
	private int id;

	private String name; 

	@Enumerated(EnumType.STRING)
	public Level level;
	
	private LocalDate birthDay;
	
	public static final CurrencyUnit CURRENCY = Monetary.getCurrency("USD");
	
	@Transient
    private MonetaryAmountFactory<?> amountFactory = Monetary.getDefaultAmountFactory();

    @Transient
    private String currencyCode = CURRENCY.getCurrencyCode();
	
	@Transient
    private MonetaryAmount salary;
	
	//10 digits precision and 2 digits after decimal
    @Column(name="salary", precision=10, scale=2)
    private BigDecimal baseSalary;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Address> addresses;


	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id", referencedColumnName = "id") // (optional)this will create user id in employee table
	@JsonIgnore
	@MapsId
	private User user;
	
	@PrePersist
    protected void onPrePersist() {
        currencyCode = salary.getCurrency().getCurrencyCode();
        baseSalary = salary.getNumber()
                .numberValue(BigDecimal.class)
                .setScale(salary.getCurrency().getDefaultFractionDigits(),
                        RoundingMode.HALF_EVEN);
    }

    @PostLoad
    protected void onPostLoad() {
        this.salary =
                Monetary.getDefaultAmountFactory()
                        .setNumber(baseSalary)
                        .setCurrency(currencyCode)
                        .create();
    }

}