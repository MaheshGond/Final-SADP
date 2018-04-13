package CalculatorModel.Interface;

public interface Statistical extends Calculator
{	
	public double max();
	
	public double min();

	public double mean();
	
	public double var();
	
	public double std();
}
