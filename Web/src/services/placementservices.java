package services;

import java.util.HashSet;
import java.util.Map;

import database.*;
import model.student;

public class placementservices {
	
	private static Map<String,HashSet<student>> placed=database.getPlaced();
	
	public HashSet<student> getPlaced(String username)
	{
		return placed.get(username);
	}
	
	public  boolean addPlaced(String company_username,HashSet<student> s){
		
	
		
		if(placed.containsKey(company_username))
		{
			
			HashSet<student> ls=placed.get(company_username);
			ls.addAll(s);
			placed.put(company_username,ls);
			return true;
		}
		else if (database.getCompanies().containsKey(company_username))
		{
			placed.put(company_username,s);
			return true;
		}
		
		return false;
	}
	
	
	public boolean deletePlaced(String company_username,student s)
	{
		if(placed.containsKey(company_username))
		{
			
			HashSet<student> ls=placed.get(company_username);
			if(ls.remove(s))
			{
				placed.put(company_username,ls);
				return true;
			}
		
		}
		return false;
		
	}
}
