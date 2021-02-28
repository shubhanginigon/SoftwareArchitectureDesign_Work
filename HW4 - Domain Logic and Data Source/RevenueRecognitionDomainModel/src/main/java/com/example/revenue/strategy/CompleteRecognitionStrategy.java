package com.example.revenue.strategy;

import com.example.revenue.model.Contract;

public class CompleteRecognitionStrategy implements RecognitionStrategy {

	@Override
	public void calculateRevenueRecognitions(Contract contract) {
		contract.addRevenueRecognition(
				contract.getRevenue(), contract.getDateSigned());
	}

}