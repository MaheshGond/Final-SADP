import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class Home {
	
	
	public FileInputStream start() throws FileNotFoundException
	{
		return new FileInputStream("E:\\Programs\\Web\\WebContent\\login.html");
	}

}
