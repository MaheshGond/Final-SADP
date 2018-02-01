package businesslogic;

import java.io.*;  
import java.net.*;  
import java.util.Scanner;
public class server {  
    public static void main(String[] args){  
    	try{  
    	ServerSocket ss=new ServerSocket(6666);  
	    Socket s=ss.accept();
	    DataInputStream dis=new DataInputStream(s.getInputStream());
	    DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
	    String str ="";
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Client connected "); 
	    while(str.compareTo("quit")!=0)
	    {
	    	
	    	str=(String)dis.readUTF();  
		    System.out.println("CLient : "+str);
		    System.out.print("Me : ");
		    calculator cal = new calculator();
		    
		    str = cal.evaluate(str)+"";
		    String spt[] = {str.substring(0, str.lastIndexOf('.')),str.substring(str.lastIndexOf('.')+1)};
		    if(Integer.parseInt(spt[1])==0)
		    	str = spt[0];
		    System.out.println(str);
		    dout.writeUTF(str);
		    dout.flush();
	    }
	    System.out.println("Client disconnected ");
	    ss.close();  
	    }catch(Exception e){System.out.println(e);}  
    }  
}  