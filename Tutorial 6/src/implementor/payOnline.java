package implementor;

public class payOnline implements payment {
	
	public void pay(double p) {
		System.out.println("Pay Online "+p);
	}
	
}
