package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class notice {
	
	private Long id;
	private String content;
	
	public notice(){
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public notice(Long id, String content) {
		
		this.id = id;
		this.content = content;
	}

}
