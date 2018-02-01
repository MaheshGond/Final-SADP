package businesslogic;
import java.io.*;  
import java.net.*;

public class server implements Runnable{  
	static String str;
	static ServerSocket ss;
	static Socket s;
	static DataInputStream dis;
	static DataOutputStream dout;
	static Thread t;
	static server SS;
	static FileWriter out;
	static File f;
    public static void main(String[] args){  
    	try{  
    	f = new File("E:\\Programs\\Tutorial 2\\o.txt");
    	if(f.exists())
    	{
    		f.delete();
    		f = new File("E:\\Programs\\Tutorial 2\\o.txt");
    		f.createNewFile();
    	}
    	out = new FileWriter(f,true);
    	System.out.println("Server started ");
    	ss = new ServerSocket(6666); 
	    str ="";
	    while(str.compareTo("quit")!=0)
	    {
	    	 
		    s=ss.accept();
		    dis=new DataInputStream(s.getInputStream());
		    dout=new DataOutputStream(s.getOutputStream());  
	    	str=(String)dis.readUTF();  
		    System.out.println("CLient : "+str);
		    if(str.compareTo("quit")==0)
				{
		    	out.close();
		    	break;
				}
		    SS = new server();
		    t = new Thread(SS);
		    t.start();
		    dout.writeUTF(str);
		    dout.flush();
		    
	    }
	    out.close();
	    
	    }catch(Exception e){System.out.println(e+" ++++");}  
    }  
   
	@Override
	public void run() {
		
		calculator cal = new calculator();
		if(str.compareTo("quit")==0)
			return;
	    str = cal.evaluate(str)+"";
	    try {
			out.append(str+System.getProperty("line.separator"));
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	    
	    System.out.println("Answer : "+str);
	    
	}
}  