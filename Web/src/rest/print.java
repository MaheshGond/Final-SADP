package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/check")
public class print {
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String printForm(@FormParam("usertype") String usertype,
							@FormParam("username") String username,
							@FormParam("psw") String psw)
	{
		
		
		return  usertype + "\n" + username + "\n" + psw + "\n";
	}

}
