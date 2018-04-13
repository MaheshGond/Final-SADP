package CalculatorModel.CalculatorFuntions;

import java.util.Arrays;

import CalculatorModel.Interface.Geometric;

public class GeometricCalculator implements Geometric
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
	
	public double sin(double x)
	{
		return Math.sin(x);
	}

	public double cos(double x)
	{
		return Math.cos(x);
	}

	public double tan(double x)
	{
		return Math.tan(x);
	}
	
	@Override
	public double calculate(String s, double[] value) {
		//System.out.println("Geometric");
		//System.out.println("geo "+Arrays.toString(value));
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
		else if(s.compareTo("divide")==0)	
		{
			return divide(value[0],value[1]);
		}
		else if(s.compareTo("sin")==0)	
		{
			return sin(value[0]);
		}
		else if(s.compareTo("cos")==0)	
		{
			return cos(value[0]);
		}
		else if(s.compareTo("tan")==0)	
		{
			return tan(value[0]);
		}
		return 0;
		
	}

}
