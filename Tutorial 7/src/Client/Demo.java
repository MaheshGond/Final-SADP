package Client;
import java.util.Scanner;

import Interpreter.ClientHandler;
import Interpreter.InfixToPostfix;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		InfixToPostfix itp = new InfixToPostfix();
		String result = itp.convert(s);
		System.out.println(result);
		ClientHandler clientH = new ClientHandler();
		System.out.println(clientH.eval(s));
		
	}

}
