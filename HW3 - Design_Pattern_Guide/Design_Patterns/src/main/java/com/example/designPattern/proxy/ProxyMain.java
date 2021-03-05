package com.example.designPattern.proxy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProxyMain {
	public static void main(String[] args) {
		CommandAccess access = new CommandAccessProxy("Shubhi","Something");
		try {
			Process p = access.runService("cmd /c dir");
			printResult(p);
			Process p2 = access.runService("/somefolder/something.exe");
			printResult(p2);
		} catch (Exception e) {
			System.out.println("Exception Message::" + e.getMessage());
		}
	}
	
	static void printResult(Process p) {
		String line;
		BufferedReader bri = new BufferedReader(
				new InputStreamReader(p.getInputStream()));
		try {
			while ((line = bri.readLine()) !=null) {
				System.out.println(line);
			}
			bri.close();
			p.waitFor();
			System.out.println("Done.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
