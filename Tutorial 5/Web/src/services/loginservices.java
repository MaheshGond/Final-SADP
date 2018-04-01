package services;

import java.util.Map;

import database.database;
import model.user;

public class loginservices {
	
	private static Map<String,user> users = database.getusers();
	
	public boolean verify(user u){
		String user_id=u.getUserId();
		if(users.containsKey(user_id))
		{
			user p=users.get(user_id);
			if(p.getPassword().equals(u.getPassword()))
				return true;
		}
		return false;
		
		
	}
}
