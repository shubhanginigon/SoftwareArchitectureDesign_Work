package com.example.designPattern.state;

public class Swordman implements State {
	
	int agi = 7;
	int atk = 13;
	int def = 5;
	@Override
	public void increaseDefense(int increment) {
		// TODO Auto-generated method stub
		def = def + increment;
		
	}
	@Override
	public void speedUp(int increment) {
		// TODO Auto-generated method stub
		atk =atk + 2 * increment;
		agi = agi + increment;
	}
	@Override
	public void increaseAttack(int increment) {
		// TODO Auto-generated method stub
		atk = atk + increment;
		def = def - (int)0.3 * increment;
	}
	@Override
	public void printStates() {
		// TODO Auto-generated method stub
		System.out.println("Agi-atk-def: " + agi + "-" + atk + "-" + def);
	}
	
	

}
