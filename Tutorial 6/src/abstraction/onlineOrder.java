package abstraction;

import implementor.payment;

public class onlineOrder extends abstractOrder {

	protected onlineOrder(payment pa) {
		super(pa);
	}

	@Override
	public void pay(double p) {
		
		System.out.println("Online Order");
		pa.pay(p);
	}
	
}
