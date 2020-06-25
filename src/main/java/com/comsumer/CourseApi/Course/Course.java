package com.comsumer.CourseApi.Course;

import javax.persistence.Entity;
import javax.persistence.Id		;
import javax.persistence.ManyToOne;

import com.comsumer.CourseApi.Topic.Topic;

@Entity
public class Course {
	
	@Id
	private Integer Id;
	private String name;
	
	@ManyToOne
	private Topic topic;
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course(int id, String name,int topicId) {
		super();
		Id = id;
		this.name = name;
		this.topic=new Topic(topicId,"");
	}
	public Course() {
		
		
	}
	

}
