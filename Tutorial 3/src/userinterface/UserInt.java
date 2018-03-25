package userinterface;

import java.util.*;

import CalculatorLogic.CalculatorLogic;

public class UserInt
{ 
    private static String exp = new String();
    private static String str=new String();
	
    public static String getExp(){
    	Scanner sc = new Scanner(System.in);
		System.out.println("Enter Expression:");
        exp = sc.nextLine();
        return exp;	
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CalculatorLogic cal = new CalculatorLogic();
		System.out.println("Enter \"quit\" when you want disconnect...");
		while(true){
	    str = cal.evaluate(getExp())+"";
		String spt[] = {str.substring(0, str.lastIndexOf('.')),str.substring(str.lastIndexOf('.')+1)};
	    if(Integer.parseInt(spt[1])==0)
	    	str = spt[0];
		System.out.println("Result: " + str );
		String choice = sc.nextLine();
		if(choice.equals("quit"))
			break;
		}
		System.out.println("disconnected...");
	}
}