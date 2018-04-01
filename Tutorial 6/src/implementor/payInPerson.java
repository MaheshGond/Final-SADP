package implementor;

public class payInPerson implements payment{
	
	public void pay(double p) {
		System.out.println("Pay in Person "+p);
	}
	
}
