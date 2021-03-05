package com.example.hibernate.model;

public enum LeaveType {
	
	SICK(Values.SICK), ANNUAL(Values.ANNUAL);
	
	private LeaveType (String val) {
		if (!this.name().equals(val))
			throw new IllegalArgumentException("Incorrect use of Elanguage");
	}
	
	public static class Values {
		public static final String SICK = "SICK";
		public static final String ANNUAL = "ANNUAL";
	}
}
