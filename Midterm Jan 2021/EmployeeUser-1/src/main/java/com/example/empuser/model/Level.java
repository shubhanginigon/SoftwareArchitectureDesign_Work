package com.example.empuser.model;

public enum Level {
	
	C1(Values.C1,200), C2(Values.C2,500), C3(Values.C3,1000);
	
	private float salary;
	
	private Level (String val, float salary) {
	     // force equality between name of enum instance, and value of constant
	     if (!this.name().equals(val))
	        throw new IllegalArgumentException("Incorrect use of ELanguage");
	     
	     this.salary = salary ;
	  }
	
	public static class Values{
		public static final String C1 = "C1";
		public static final String C2 = "C2";
		public static final String C3 = "C3";
	}
}
