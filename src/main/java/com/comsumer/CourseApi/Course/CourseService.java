package com.comsumer.CourseApi.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseR;
	
	
	public List<Course> getAllCourses(int id) {
		List<Course> courses=new ArrayList<>();
		courseR.findByTopicId(id)
		.forEach(courses::add);;
		return courses;
		//return topic;
	}
	
	public Optional<Course> getCourse(int id) {
		
		return courseR.findById(id);
		//return topic.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addCourse(Course course2) {
		//topic.add(topic2);
		courseR.save(course2);
		
	}

	public void updateCourse(Course course2) {
		/*for(int i=0; i<topic.size();i++) {
			Topic t=topic.get(i);
			if(t.getId()==id) {
				topic.set(id, topic2);
			}
		}*/
		courseR.save(course2);
		
	}

	public void deleteCourse(int id) {
		//topic.remove(id);
		courseR.deleteById(id);
	}
	
	
	
}
