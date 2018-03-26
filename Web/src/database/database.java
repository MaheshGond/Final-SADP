package database;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import model.company;
import model.notice;
import model.student;
import model.tpostaff;
import model.user;

public class database 
{
	private static Map<String,user> user_login=new  HashMap<>();
	private static Map<String,student> students = new HashMap<>();
	private static Map<String,tpostaff> tpostaff = new HashMap<>();
	private static Map<String,company> companies = new HashMap<>();
	private static Map<String,HashSet<student>> applied=new HashMap<>();
	private static Map<String,HashSet<student>> shortlist=new HashMap<>();
	private static Map<String,HashSet<student>> placed=new HashMap<>();
	private static Map<Long,notice> notices=new HashMap<>();

	static{
	
		//students
		students.put("s1",new student("s1","s1pass","name","mechanical",4,(float)8.19));
		students.put("s2",new student("s2","s2pass","name","mechanical",4,(float)8.19));
		
		students.put("s3",new student("s3","s3pass","name","it",4,(float)8.19));
		students.put("s4",new student("s4","s4pass","name","it",4,(float)8.19));
		
		students.put("s5",new student("s5","s5pass","name","comps",4,(float)8.19));
		students.put("s6",new student("s6","s6pass","name","comps",4,(float)8.19));
		
		
		
		user_login.put("s1",new user("s1","s1pass","name"));
		user_login.put("s2",new user("s2","s2pass","name"));
		user_login.put("s3",new user("s3","s3pass","name"));
		user_login.put("s4",new user("s4","s4pass","name"));
		user_login.put("s5",new user("s5","s5pass","name"));
		user_login.put("s6",new user("s6","s6pass","name"));
		
		//TPO Staff
		tpostaff.put("t1",new tpostaff("t1","t1pass","name","tpo_head"));
		
		user_login.put("t1",new user("t1","t1pass","name"));
		
		//company
		
		companies.put("c1",new company("c1","c1pass","name",1000,new Date(),new String[]{"it","comps"},4));
		companies.put("c2",new company("c2","c2pass","name",1000,new Date(),new String[]{"it","comps","mechanical"},4));
		companies.put("c3",new company("c3","c3pass","name",1000,new Date(),new String[]{"mechanical"},4));
		
		user_login.put("c1",new user("c1","c1pass","name"));
		user_login.put("c2",new user("c2","c2pass","name"));
		user_login.put("c3",new user("c3","c3pass","name"));
		
	
	}
	public static Map<String, user> getusers() {
		
		return user_login;
	}
	
	public static Map<String,student> getstudents() {
		
		return students;
	}
	
	public static Map<String,company> getCompanies() {
		
		return companies;
	}
	public static Map<String,tpostaff> getTPOStaff() {
		
		return tpostaff;
	}
	public static Map<String,HashSet<student>> getApplied() {
		
		return applied;
	}
	public static Map<String,HashSet<student>> getShortList() {

		return shortlist;
	}	
	public static Map<String,HashSet<student>> getPlaced() {

		return placed;
	}
	public static Map<Long,notice> getNotices() {
		
		return notices;
	}
	
}
