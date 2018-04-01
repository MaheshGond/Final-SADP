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
import services.placementservices;

@Path("/placed")
public class placed{
	
	placementservices ps=new placementservices();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{company_username}")
	
		public HashSet<student> getPlaced(@PathParam("company_username") String username){
			return ps.getPlaced(username);
		}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{company_username}")
	public String addPlaced(@PathParam("company_username") String username,HashSet<student> s)
	{
		
		if(ps.addPlaced(username,s))
			return "Success";
		return "Failure";
	}
	
	
	@DELETE
	@Path("/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePlaced(@PathParam("username") String username,student s)
	{
		if(ps.deletePlaced(username,s))
			return "Success";
		return "Failure";
	}

}
