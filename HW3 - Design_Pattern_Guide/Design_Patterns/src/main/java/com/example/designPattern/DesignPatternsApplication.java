package com.example.designPattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.designPattern.adapter.CsvAdapterImpl;
import com.example.designPattern.adapter.CsvFormattable;
import com.example.designPattern.adapter.CsvFormatter;
import com.example.designPattern.adapter.LineFormattable;
import com.example.designPattern.adapter.NewLineFormatter;
//import com.example.designPattern.decorator.Swordman;
import com.example.designPattern.state.Swordman;
import com.example.designPattern.decorator.Weapon;
import com.example.designPattern.decorator.Character;

@SpringBootApplication
public class DesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternsApplication.class, args);
		
		//Main code to run Adapter
		/*
		 * String testString =
		 * "Formatting line 1. Formatting Line 2. Formatting line 3."; LineFormattable
		 * newLineFormatter = new NewLineFormatter(); String resultString =
		 * newLineFormatter.formatText(testString); System.out.println(resultString);
		 * 
		 * CsvFormattable csvFormatter = new CsvFormatter(); LineFormattable csvAdapter
		 * = new CsvAdapterImpl(csvFormatter); String resultCsvString =
		 * csvAdapter.formatText(testString); System.out.println(resultCsvString);
		 */
		
		//Main code to run Decorator
		//simple swordman
		/*
		 * Character swordMan = new Swordman(); System.out.println(swordMan.getLore() +
		 * " has attack of " + swordMan.attack());
		 * 
		 * //swordman with weapon and armor Character decoratedSwordMan = new
		 * Swordman(); decoratedSwordMan = new Weapon(decoratedSwordMan);
		 * System.out.println(decoratedSwordMan.getLore() + "has attack of " +
		 * decoratedSwordMan.attack());
		 */
		
		//Main code for State
		Swordman sm = new Swordman();
		sm.increaseAttack(4);
		sm.speedUp(3);
		sm.increaseDefense(1);
		sm.speedUp(2);
		
		System.out.println("Character present state; ");
		sm.printStates();
	}

}
