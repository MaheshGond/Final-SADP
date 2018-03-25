package test;

import static org.junit.jupiter.api.Assertions.*;

import CalculatorLogic.CalculatorLogic;

class Test {
	
	@org.junit.jupiter.api.Test
	public void test1() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("10+20");
		
		assertEquals(30.0+"",result+"");
	}
	@org.junit.jupiter.api.Test
	public void test2() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("20-10");

		assertEquals(10.0+"",result+"");
	}
	@org.junit.jupiter.api.Test
	public void test3() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("5*6");

		assertEquals(30.0+"",result+"");
	}
	@org.junit.jupiter.api.Test
	public void test4() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("6/3");

		assertEquals(2.0+"",result+"");
	}
	@org.junit.jupiter.api.Test
	public void test5() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("9*6-3");

		assertEquals(51.0+"",result+"");
	}
	@org.junit.jupiter.api.Test
	public void test6() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("9/3+5");

		assertEquals(8.0+"",result+"");
	}
	@org.junit.jupiter.api.Test
	public void test7() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("9*4/12");

		assertEquals(3.0+"",result+"");
	}
	@org.junit.jupiter.api.Test
	public void test8() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("(2+3)*5");

		assertEquals(25.0+"",result+"");
	}
	@org.junit.jupiter.api.Test
	public void test9() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("(6-4)/2");

		assertEquals(1.0+"",result+"");
	}
	@org.junit.jupiter.api.Test
	public void test10() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("4*5+6/3*5");

		assertEquals(30.0+"",result+"");
	}
	@org.junit.jupiter.api.Test
	public void test11() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("(20*3)/4-52*(10+6/3)");

		assertEquals(-609.0+"",result+"");
	}
	@org.junit.jupiter.api.Test
	public void test12() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("5.5/1.2*3.1");

		assertEquals(14.2083+"",result+"");
	}
	@org.junit.jupiter.api.Test
   public void test13() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("10/3");

		assertEquals(3.3333+"",result+"");
	}
	@org.junit.jupiter.api.Test
   public void test14() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("10*2.3+9-1");

		assertEquals(31.0+"",result+"");
	}
	@org.junit.jupiter.api.Test
   public void test15() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("(5.6/8)*5-0.2");

		assertEquals(3.3+"",result+"");
	}
	@org.junit.jupiter.api.Test
   public void test16() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("5.5/1.2*3.1");

		assertEquals(14.2083+"",result+"");
	}
	@org.junit.jupiter.api.Test
   public void test17() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("15*0.0");

		assertEquals(0.0+"",result+"");
	}
	@org.junit.jupiter.api.Test
   public void test18() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("15/0");

		assertEquals(Double.POSITIVE_INFINITY+"",result+"");
	}
	@org.junit.jupiter.api.Test
   public void test19() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("(4+6)/5-(5*1");
		//System.out.println(result);
		assertEquals(-3.0+"",result+"");
	}
	@org.junit.jupiter.api.Test
   public void test20() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("8*2+/3");

		assertEquals(10.23+"",result+"");
	}
	@org.junit.jupiter.api.Test
   public void test21() {
		CalculatorLogic cal = new CalculatorLogic();
		double result = cal.evaluate("80/77-(73*96+89)*3-56");

		assertEquals(-21345.9610+"",result+"");
	}
	@org.junit.jupiter.api.Test
	  public void test22() 
	    {
			CalculatorLogic cal = new CalculatorLogic();
			double result = cal.evaluate("(69.23/3+968)*24-2456");
			assertEquals(21329.84+"",result+"");
		}
	@org.junit.jupiter.api.Test
	   public void test23() 
	    {
			CalculatorLogic cal = new CalculatorLogic();
			double result = cal.evaluate("78/1000*6382");
			assertEquals(497.796+"",result+"");
		}
	@org.junit.jupiter.api.Test
	   public void test24() 
	    {
			CalculatorLogic cal = new CalculatorLogic();
			double result = cal.evaluate("(30*2)+60");
			assertEquals(120.0+"",result+"");
		}
	@org.junit.jupiter.api.Test
	   public void test25() 
	    {
			CalculatorLogic cal = new CalculatorLogic();
			double result = cal.evaluate("6345+321452*12");
			assertEquals(3863769.0+"",result+"");
		}
}
