package com.example.designPattern.proxy;

public class CommandAccessImpl implements CommandAccess {

	@Override
	public Process runService(String cmd) throws Exception {
		Process p = Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "'Command executed.");
		return p;
	}
	
	

}
