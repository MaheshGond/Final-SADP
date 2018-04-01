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
import javax.ws.rs.core.MediaType;


import model.notice;
import services.noticeservices;

@Path("/notices")
public class notices {
	
	noticeservices ns=new noticeservices();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<notice> getNotices()
	{
		return ns.getNotices();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public notice getNotice(@PathParam("id") Long id)
	
	{
		return ns.getNotice(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addNotice(notice n)
	{
		if(ns.addNotice(n))
			return "Success";
		return "Failure";
	}
	
	@PUT	
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateNotice(@PathParam("id") long id,notice n){
		
		n.setId(id);
		if(ns.updateNotice(n))
			return "Success";
		return "Failure";
		
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteMessage(@PathParam("id") long id)
	{
		if(ns.removeNotice(id))
			return "Success";
		return "Failure";
	}
}
