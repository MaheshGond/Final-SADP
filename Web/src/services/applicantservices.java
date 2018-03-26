package services;

import java.util.HashSet;
import java.util.Map;

import database.*;
import model.student;

public class applicantservices{
	
	private static Map<String,HashSet<student>> applied = database.getApplied();

	public HashSet<student> getApplied(String username)
	{
		return applied.get(username);
	}
	
	public boolean addApplied(String company_username,student s){
		
		
		
		if(applied.containsKey(company_username))
		{
			
			HashSet<student> ls=applied.get(company_username);
			ls.add(s);
			applied.put(company_username,ls);
			return true;
		}
		else if (database.getCompanies().containsKey(company_username))
		{
			HashSet<student> d=new HashSet<student>();
			d.add(s);
			applied.put(company_username,d);
			return true;
		}
		
		return false;
	}
	
	public boolean deleteApplied(String company_username,student s)
	{
		if(applied.containsKey(company_username))
		{
			
			HashSet<student> ls=applied.get(company_username);
			if(ls.remove(s))
			{
				applied.put(company_username,ls);
				return true;
			}
		
		}
		return false;
		
	}

}
