package test;

import static org.junit.jupiter.api.Assertions.*;

import CalculatorLogic.CalculatorLogic;

//import org.junit.jupiter.api.Test;

class ttt {

	@org.junit.jupiter.api.Test
	void test1() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("tan(40+5)");
		System.out.println("tan(40+5) = "+result);
		assertEquals(1.0+"",result+"");
		
	}
	
	@org.junit.jupiter.api.Test
	void test2() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("mean(1,2,3)+sin(45+45)+tan(25+20)+mean(1,2,3)+10+20/2*3-20/10");
		System.out.println("Result = "+result);
		assertEquals(44.0+"",result+"");
	}
	
	@org.junit.jupiter.api.Test
	void test3() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("sin(45+45)");
		System.out.println("sin(45+45) = "+result);
		assertEquals(1.0+"",result+"");
	}
	
	
	

}
