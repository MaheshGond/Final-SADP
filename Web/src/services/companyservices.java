package services;

import java.util.ArrayList;
import java.util.Map;

import database.*;
import model.company;
import model.user;

public class companyservices {
	
	private static Map<String,company> companies = database.getCompanies();
	private static Map<String,user> user_login = database.getusers();

	public company getCompany(String username){
		
		return companies.get(username);	}



	public ArrayList<company> getCompanies(){
		
		return new ArrayList<company>(companies.values());
	
}
public ArrayList<company> getCompaniesByBranch(String branch){
		
		
		ArrayList<company> cs= new ArrayList<company>();
		for(company c: companies.values())
		{
			
			String[] branches=c.getBranches();
			for(String s : branches)
			{
				if(s.equalsIgnoreCase(branch)){
					cs.add(c);
					break;}
			}
				
		}
		return cs;
		
		
		
	}

public boolean addCompany(company c)
{
	if(companies.containsKey(c.getUserId()))
		return false;
	companies.put(c.getUserId(),c);
	user_login.put(c.getUserId(),new user(c.getUserId(),c.getPassword(),c.getName()));
	return true;
}

public boolean updateCompany(company c)
{
	if(companies.containsKey(c.getUserId()))
	{
		companies.put(c.getUserId(),c);
		user_login.put(c.getUserId(),new user(c.getUserId(),c.getPassword(),c.getName()));
		return true;
	}
	
	return false;
}

public boolean removeCompany(String username)
{
	if(companies.containsKey(username))
	{
		companies.remove(username);
		user_login.remove(username);
		return true;
	}
	
	return false;
}

}