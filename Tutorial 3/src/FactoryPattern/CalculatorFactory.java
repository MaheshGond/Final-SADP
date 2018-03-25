package FactoryPattern;

import CalculatorFuntions.*;
import Interface.Calculator;

public class CalculatorFactory 
{
	
	public Calculator createCalculator(String s)
	{
		Calculator cal = null;
		if(s.compareTo("Basic")==0)
			cal = new BasicCalculator();
		else if(s.compareTo("Geometric")==0)
			cal = new GeometricCalculator();
		else
			cal = new StatisticalCalculator();
		return cal;
	}
	
}
