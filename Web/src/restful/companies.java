package restful;


import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.company;
import services.companyservices;

@Path("/companies")
public class companies {
	
	companyservices cs=new companyservices();
	
	@GET
	@Path("/{company_username}")
	@Produces(MediaType.APPLICATION_JSON)
	public company getcompany(@PathParam("company_username") String username){
		
		return cs.getCompany(username);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<company> getCompanies(@QueryParam("branch") String branch){
		if(branch==null)
			return cs.getCompanies();
		return cs.getCompaniesByBranch(branch);
	}
	
	@POST	
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addcompany(company c){
		
		if( cs.addCompany(c))
			return "Success";
		return "Failure";
		
	}
	
	@PUT	
	@Path("/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatecompany(@PathParam("username") String username,company c){
		
		c.setUserId(username);
		if(cs.updateCompany(c))
			return "Success";
		return "Failure";
		
	}
	
	@DELETE
	@Path("/{username}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deletecompany(@PathParam("username") String username)
	{
		if(cs.removeCompany(username))
			return "Success";
		return "Failure";
	}
	
}
