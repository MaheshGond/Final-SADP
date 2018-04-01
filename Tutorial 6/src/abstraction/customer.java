package abstraction;
import java.util.*;

import implementor.*;

public class customer {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in); 
		int ch;
		
		
		System.out.println("Select your order type\n1.Online\n2.Telephone\n3.Walk-In");
		ch=input.nextInt();
		
		switch(ch) {
		case 1:
			onlineOrder onor=new onlineOrder(new payOnline());
			onor.pay(57.5);
			break;
		case 2:
			telephoneOrder tor=new telephoneOrder(new payInPerson());
			tor.pay(52);
			break;
		case 3:
			walkInOrder wor=new walkInOrder(new payInPerson());
			wor.pay(52);
			break;
		default:
			System.out.println("Please Enter A Valid Option");
				
		}

	}

}
