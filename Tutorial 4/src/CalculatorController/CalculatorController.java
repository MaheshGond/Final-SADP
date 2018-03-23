package CalculatorController;

import java.util.Observable;
import java.util.Observer;

import CalculatorLogic.CalculatorLogic;
import CalculatorView.CalculatorView;

public class CalculatorController implements Observer {
	private CalculatorLogic calL;
	private CalculatorView calV;

	public CalculatorController(CalculatorView calV,CalculatorLogic calL)
	{
		this.calL = calL;
		this.calV = calV;
	}
	public void getExp()
	{
		calV.createV();
	}
	public void update(Observable arg0, Object arg1) {
		String exp = calV.getT().getText().toString();
		calV.setT(calL.evaluate(exp)+"");
		System.out.println(calL.evaluate(exp));
	}
	
	
}
