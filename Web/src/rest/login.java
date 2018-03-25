package rest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Path("/Home")
public class login {

	@GET
	@Path("/login")
	@Produces(MediaType.TEXT_HTML)
	public FileInputStream check() throws FileNotFoundException
	{
		return new FileInputStream("E:/Programs/Web/WebContent/login.html");
	}
	
	@GET
	@Path("/student")
	@Produces(MediaType.TEXT_HTML)
	public FileInputStream check1() throws FileNotFoundException
	{
		return new FileInputStream("E:/Programs/Web/WebContent/student.html");
	}
	
	/*
	@POST
	@Path("/login/check")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public FileInputStream printForm(@FormParam("usertype") String usertype,
							@FormParam("username") String username,
							@FormParam("psw") String psw) throws FileNotFoundException
	{
		if(usertype.compareTo("student")==0)
		{
			return new FileInputStream("E:/Programs/Web/WebContent/student.html");
		}
		else if(usertype.compareTo("tpo")==0)
			return new FileInputStream("E:/Programs/Web/WebContent/tpo.html");
		return new FileInputStream("E:/Programs/Web/WebContent/company.html");
	}
	*/
	
	
	
}
