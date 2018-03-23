package CalculatorLogic;

import java.util.Arrays;

import Interface.*;

public class Calculator implements BasicCalculator,GeometricCalculator,StatisticalCalculator
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
	
	private int n;
	private double x[];
	
	public void fill_table(String y[])
	{
		int i=0;
		x = new double[y.length];
		for(String s:y)
			x[i++] = Double.parseDouble(s);
		n = x.length;
		//System.out.println(Arrays.toString(x));
	}
	
	public double max()
	{
		
		double max = Double.MIN_VALUE;
		for(double s: x)
			if(max<s)
				max = s;
		return max;
	}
	
	public double min()
	{
		
		double min = Double.MAX_VALUE;
		for(double s: x)
			if(min>s)
				min = s;
		return min;
	}

	public double mean()
	{
		
		double sum = 0.0;
		for(double s: x)
			sum += s;
		return sum/n;
	}
	
	public double var()
	{
		
		double var = 0.0, mean = mean();
		for(int i=0;i<n;i++)
			var += Math.pow(x[i]-mean, 2);
		return var/n;
	}
	
	public double std()
	{
		
		return Math.sqrt(var());
	}




}
