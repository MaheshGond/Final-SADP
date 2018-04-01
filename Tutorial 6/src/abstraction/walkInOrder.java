package abstraction;
import implementor.payment;

public class walkInOrder extends abstractOrder{

	protected walkInOrder(payment pa) {
		super(pa);
	}

	@Override
	public void pay(double p) {
		
		System.out.println("Walk-In Order");
		pa.pay(p);
	}

}
