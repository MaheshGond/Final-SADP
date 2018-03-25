package CalculatorFuntions;

import Interface.Calculator;

public class BasicCalculator implements Calculator
{
	public double add(double a, double b) {
		
		return a+b;
	}

	public double subtract(double a, double b) {
		
		return a-b;
	}

	public double multiply(double a, double b) {
		
		return a*b;
	}

	public double divide(double a, double b) {
		if(b == 0)
            return Double.POSITIVE_INFINITY;
        return a/b;
	}

	@Override
	public double calculate(String s, double[] value) {
		if(s.compareTo("add")==0)
		{
			return add(value[0],value[1]);
		}
		else if(s.compareTo("subtract")==0)
		{
			return subtract(value[0],value[1]);
		}
		else if(s.compareTo("multiply")==0)
		{
			return multiply(value[0],value[1]);
		}
			
		return divide(value[0],value[1]);
	}
	

}
