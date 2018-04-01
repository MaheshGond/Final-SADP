package abstraction;
import implementor.payment;

public class telephoneOrder extends abstractOrder{

	protected telephoneOrder(payment pa) {
		super(pa);
	}

	@Override
	public void pay(double p) {
		
		System.out.println("Telephone Order");
		pa.pay(p);
	}
	
}
