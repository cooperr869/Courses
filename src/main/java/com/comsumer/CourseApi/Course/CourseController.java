package com.comsumer.CourseApi.Course;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comsumer.CourseApi.Topic.Topic;

@RestController
public class CourseController {

	
	@Autowired	
	CourseService courseService;
	@RequestMapping("/topic/{id}/course")
	public List<Course> getAllCourses(@PathVariable int id){
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topic/{id}/courses/{courseId}")
	public Optional<Course> getCourse(@PathVariable int courseId) {
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topic/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable int topicId) {
		course.setTopic(new Topic(topicId,""));
		courseService.addCourse(course);;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topic/{id}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable int courseId, @PathVariable int id) {
		course.setTopic(new Topic(id,""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topic/{id}/courses/{courseId}")
	public void deleteCourse(@PathVariable int id) {
		courseService.deleteCourse(id);
		
	}
}











