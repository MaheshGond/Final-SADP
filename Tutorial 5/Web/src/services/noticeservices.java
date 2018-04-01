package services;

import java.util.ArrayList;
import java.util.Map;

import database.database;
import model.notice;

public class noticeservices {

	private static Map<Long,notice> notices = database.getNotices();
	
	public ArrayList<notice> getNotices()
	{
		return new ArrayList<notice>( notices.values());
	}
	
	public notice getNotice(Long id){
		
		return notices.get(id);
	}
	
	
	public boolean addNotice(notice n)
	{
		n.setId((long) (notices.size()+1));
		notices.put(n.getId(),n);
		return true;
		
		
	}
	public boolean updateNotice(notice n)
	{
		if (n.getId() <= 0) {
			return false;
		}
		notices.put(n.getId(),n);
		return true;
	}
	public boolean removeNotice(Long id)
	{
		notice n= notices.remove(id);
		if(n==null)
			return false;
		return true;
	}
}
