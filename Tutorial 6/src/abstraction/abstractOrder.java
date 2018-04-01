package abstraction;
import implementor.payment;


abstract class abstractOrder {
	
	protected payment pa;
	
	protected abstractOrder(payment pa) {
		this.pa=pa;
	}
	
	public abstract void pay(double p);	
}
