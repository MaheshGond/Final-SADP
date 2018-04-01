package restful;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.user;
import services.loginservices;

@Path("/login")
public class login {
	
	loginservices ls=new loginservices();
	

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({"application/json"})
	public String verify(user u){
		
		System.out.println(u.getPassword()+" "+u.getUserId());
		if(ls.verify(u))
			return "Success";
		return "Failure";
	}
}
