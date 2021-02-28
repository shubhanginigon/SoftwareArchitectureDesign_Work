package com.example.revenue.script;

import java.time.LocalDate;

import javax.money.MonetaryAmount;

public interface RevenueRecognitionScript {
	MonetaryAmount recognizedRevenue(int contractId,LocalDate asOf);
	
	void calculateRevenueRecognition(int contractId);
	
	int insertContractInformation( int productId, MonetaryAmount contractPrice, LocalDate dateSigned);
	
	int insertProductInformation(String name, String type);

}
