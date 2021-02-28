package com.example.revenue.script;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryAmountFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.revenue.factory.RevenueRecognitionFactory;
import com.example.revenue.tablegateway.ContractTableDataGateway;
import com.example.revenue.tablegateway.ProductTableDataGateway;
import com.example.revenue.tablegateway.RevenueRecognitionTableDataGateway;

@Service
public class RevenueRecognitionScriptImpl implements RevenueRecognitionScript {
	
	CurrencyUnit CURRENCY = Monetary.getCurrency("USD");
	
	@Autowired 
	RevenueRecognitionTableDataGateway recognitionGateway;
	
	@Autowired
	RevenueRecognitionFactory rrFactory;
	
	@Autowired
	ProductTableDataGateway productGateway;
	
	@Autowired
	ContractTableDataGateway contractGateway;
	
	MonetaryAmountFactory<?> amountFactory;
	
	public RevenueRecognitionScriptImpl(RevenueRecognitionTableDataGateway recognitionGateway,
			ProductTableDataGateway productGateway, ContractTableDataGateway contractGateway) {
		super();
		this.recognitionGateway = recognitionGateway;
		this.productGateway = productGateway;
		this.contractGateway = contractGateway;
		this.amountFactory = Monetary.getDefaultAmountFactory();
	}

	@Override
	public MonetaryAmount recognizedRevenue(int contractId, LocalDate asOf) {
		BigDecimal total = BigDecimal.ZERO.setScale(CURRENCY.getDefaultFractionDigits(),RoundingMode.HALF_EVEN);
		
		try(ResultSet rs = recognitionGateway.findByContract(contractId, asOf)) {
			while (rs.next()) {
				total = total.add(rs.getBigDecimal("amount"));
			}
			return amountFactory.setNumber(total).setCurrency(CURRENCY).create();		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void calculateRevenueRecognition(int contractId) {
		try (ResultSet contracts = contractGateway.findOne(contractId)) {
			if (!contracts.next()) {
				throw new RuntimeException(String.format("Contract with id = [%d] not found", contractId));
			}
			BigDecimal totalRevenue = contracts.getBigDecimal("revenue");
			LocalDate dateSigned = contracts.getDate("dateSigned").toLocalDate();
			String type = contracts.getString("type");
			rrFactory.calculateRevenueRecognitions(type, contractId, totalRevenue, dateSigned);
			
		} catch (SQLException e) {
			// TODO Wrap as runtime application exception
			throw new RuntimeException(e);
		}		
	}

	@Override
	public int insertContractInformation(int productId, MonetaryAmount contractPrice, LocalDate dateSigned) {
		return contractGateway.insert(productId, contractPrice.getNumber().numberValue(BigDecimal.class)
				.setScale(contractPrice.getCurrency().getDefaultFractionDigits(), RoundingMode.HALF_EVEN), dateSigned);
	}

	@Override
	public int insertProductInformation(String name, String type) {
		// TODO Auto-generated method stub
		return productGateway.insert(name, type);
	}
	
	
	

}
