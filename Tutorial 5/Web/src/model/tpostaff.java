package model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class tpostaff extends user {

private String designation;
	
	public tpostaff(){}
	

	public tpostaff(String userId,String password,String name,String designation)
	{
		super(userId,password,name);
		this.designation=designation;
		
	}
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}
