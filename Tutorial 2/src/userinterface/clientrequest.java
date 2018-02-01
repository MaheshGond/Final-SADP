package userinterface;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class clientrequest {

	static Scanner sc = new Scanner(System.in);
	static int count=0;
	synchronized private static void multipleclient()
	{
		client cli = new client(count);
		cli.connect();
	}
	public static void main(String[] args) throws IOException {
		
		while(true)
		{
		
			System.out.print("Do you want to connect to server?(y/n) : ");
			String s  = sc.next();
			if(s.compareTo("y")==0)
				{
					++count;
					multipleclient();
				}
			else
			{
				client cli = new client(-1);
				cli.connect();
				break;
			}
		}
		FileReader in = new FileReader("E:/Programs/Tutorial 2/o.txt");
		BufferedReader bufferedReader = new BufferedReader(in);
		StringBuffer stringBuffer = new StringBuffer();
		String line;
		int c = count;
		while ((line = bufferedReader.readLine()) != null) {
			stringBuffer.append("Client "+(count-c+1)+" Answer : "+line);
			stringBuffer.append("\n");
		}
		in.close();
		System.out.println(stringBuffer.toString());

	}

}
