package userinterface;
import java.io.*;  
import java.net.*;  
import java.util.Scanner;
public class client { 
	private int count;
	private Socket s;
	private Scanner sc;

	public client(int count)
	{
		this.count = count;
	}
    synchronized void connect() {  
    try{      
    s = new Socket("localhost",6666);  
    DataInputStream dis=new DataInputStream(s.getInputStream());
    DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
    String str ="";
    sc = new Scanner(System.in);

    
    	if(count==-1)
    	{
    		str = "quit";
    	}
    	else
    	{
    		System.out.println("CLIENT "+count+"\nServer connected ");
    	    System.out.print("Me "+count+" : ");
    		str = sc.next();
    	}
    	dout.writeUTF(str);
    	dout.flush();
    	if(str.compareTo("quit")==0)
    		return;
    	str = dis.readUTF();
    
    System.out.println(count+" Server disconnected "); 
    }catch(Exception e){System.out.println("++++ "+e);}  
    }

	
}  