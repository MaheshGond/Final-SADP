package userinterface;
import businesslogic.calculator;
import java.util.*;
import java.io.*;

public class userInt
{ 
    private static String exp = new String();
    private static String str=new String();
	private static Scanner sc = new Scanner(System.in);
    public static String getExp(){
        
		System.out.println("Enter Expression:");
        exp = sc.nextLine();
        return exp;	
    }
	public static void main(String[] args) {
		calculator cal = new calculator();
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
