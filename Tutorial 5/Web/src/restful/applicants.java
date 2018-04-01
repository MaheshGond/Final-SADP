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
import services.applicantservices;

@Path("/applicants")
public class applicants {
	
	applicantservices as=new applicantservices();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{company_username}")
	
		public HashSet<student> getApplied(@PathParam("company_username") String username){
			return as.getApplied(username);
		}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{company_username}")
	public String apply(@PathParam("company_username") String username,student s)
	{
		if(as.addApplied(username,s))
			return "Success";
		return "Failure";
	}
	
	@DELETE
	@Path("/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteApplied(@PathParam("username") String username,student s)
	{
		if(as.deleteApplied(username,s))
			return "Success";
		return "Failure";
	}
	
}
