package services;

import java.util.ArrayList;
import java.util.Map;
import model.*;
import database.*;
import javax.ws.rs.Path;

@Path("/students")
public class studentservices {
	
	private static Map<String,student> students = database.getstudents();
	private static Map<String,user> user_login = database.getusers();
	
	public student getStudent(String username){
		return students.get(username);
	}
	public ArrayList<student> getStudents(){
		
		return new ArrayList<student>(students.values());
		
	}
	
	public ArrayList<student> getStudentsByBranch(String branch){
		
		
		ArrayList<student> as= new ArrayList<student>();
		for(student s: students.values())
		{
			
			if(s.getBranch().equalsIgnoreCase(branch))
			{
				as.add(s);
			}
				
		}
		return as;
		
		
		
	}
	public boolean addStudent(student s)
	{
		if(students.containsKey(s.getUserId()))
			return false;
		students.put(s.getUserId(),s);
		user_login.put(s.getUserId(),new user(s.getUserId(),s.getPassword(),s.getName()));
		return true;
	}
	
	public boolean updateStudent(student s)
	{
		if(students.containsKey(s.getUserId()))
		{
			students.put(s.getUserId(),s);
			user_login.put(s.getUserId(),new user(s.getUserId(),s.getPassword(),s.getName()));
			return true;
		}
		
		return false;
	}
	
	public boolean removeStudent(String username)
	{
		if(students.containsKey(username))
		{
			students.remove(username);
			user_login.remove(username);
			return true;
		}
		
		return false;
	}

}
