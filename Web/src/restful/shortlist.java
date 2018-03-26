package restful;

import java.util.HashSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.student;
import services.shortlistservices;

@Path("/shortlist")
public class shortlist {
	
	shortlistservices ss=new shortlistservices();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{company_username}")
	
		public HashSet<student> getShortListed(@PathParam("company_username") String username){
			return ss.getShortListed(username);
		}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{company_username}")
	public String addShortList(@PathParam("company_username") String username,HashSet<student> s)
	{
		if(ss.addShortListed(username,s))
			return "Success";
		return "Failure";
	}
	
	@DELETE
	@Path("/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePlaced(@PathParam("username") String username,student s)
	{
		if(ss.deleteShortlisted(username,s))
			return "Success";
		return "Failure";
	}
}
