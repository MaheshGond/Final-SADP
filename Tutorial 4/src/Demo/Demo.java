package Demo;

import CalculatorController.CalculatorController;
import CalculatorLogic.CalculatorLogic;
import CalculatorView.CalculatorView;

public class Demo {

	public static void main(String[] args) {
		CalculatorLogic calL = new CalculatorLogic();
		CalculatorView calV = new CalculatorView();
		CalculatorController calC = new CalculatorController(calV,calL);
		calV.addObserver(calC);
		calC.getExp();

	}

}
