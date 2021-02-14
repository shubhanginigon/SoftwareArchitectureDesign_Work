package com.example.designPattern.adapter;

public class CsvAdapterImpl implements LineFormattable{
	
	CsvFormattable csvFormatter;
	public CsvAdapterImpl(CsvFormattable csvFormatter) {
		this.csvFormatter = csvFormatter;
	}
	@Override
	public String formatText(String text) {
		String formattedText = csvFormatter.formatCsvText(text);
		return formattedText;
	}
	

}
