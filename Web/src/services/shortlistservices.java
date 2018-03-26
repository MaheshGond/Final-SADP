package services;

import java.util.HashSet;
import java.util.Map;

import database.*;
import model.student;

public class shortlistservices {
	 
	private static Map<String,HashSet<student>> shortlist=database.getShortList();
	
	public HashSet<student> getShortListed(String username)
	{
		return shortlist.get(username);
	}
	
	public boolean addShortListed(String company_username,HashSet<student> s){
		
		
		
		if(shortlist.containsKey(company_username))
		{
			
			HashSet<student> ls=shortlist.get(company_username);
			ls.addAll(s);
			shortlist.put(company_username,ls);
			return true;
		}
		
		else if (database.getCompanies().containsKey(company_username))
		{
			shortlist.put(company_username,s);
			return true;
		}
		return false;
	}
	
	public boolean deleteShortlisted(String company_username,student s)
	{
		if(shortlist.containsKey(company_username))
		{
			
			HashSet<student> ls=shortlist.get(company_username);
			if(ls.remove(s))
			{
				shortlist.put(company_username,ls);
				return true;
			}
		
		}
		return false;
		
	}
}
