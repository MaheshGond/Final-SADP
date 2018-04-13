package CalculatorModel.CalculatorFuntions;

import java.util.Arrays;

import CalculatorModel.Interface.Calculator;
import CalculatorModel.Interface.Statistical;

public class StatisticalCalculator implements Calculator, Statistical
{	
	private int n;
	private double x[];
	
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
	
	
	public void fill_table(double y[])
	{
		int i=0;
		n = y.length;
		x = new double[y.length];
		for(double d:y)
		{
			x[i++] = d;
		}
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
		System.out.println();
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
	
	@Override
	public double calculate(String s, double[] value) {
		//System.out.println("statiscal");
		fill_table(value);
		if(s.compareTo("max")==0)
		{
			return max();
		}
		else if(s.compareTo("min")==0)
		{
			return min();
		}
		else if(s.compareTo("mean")==0)
		{
			return mean();
		}
		else if(s.compareTo("var")==0)
		{
			return var();
		}
			
		return std();
	}
	
	
	
}
