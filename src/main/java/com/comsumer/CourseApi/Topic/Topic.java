package com.comsumer.CourseApi.Topic;

import javax.persistence.Entity;
import javax.persistence.Id		;

@Entity
public class Topic {
	
	@Id
	private Integer id;
	private String name;
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Topic(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Topic() {
		
		
	}
	

}
