package com.comsumer.CourseApi.Course;



import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comsumer.CourseApi.Topic.Topic;

@RestController
public class CourseController {

	final static Logger logger = LoggerFactory.getLogger(CourseController.class);
	@Autowired	
	CourseService courseService;
	@RequestMapping("/topic/{id}/course")
	public List<Course> getAllCourses(@PathVariable int id){
		logger.info("All courses returned successfully");
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topic/{id}/courses/{courseId}")
	public Optional<Course> getCourse(@PathVariable int courseId) {
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topic/{topicId}/courses")
	public ResponseEntity<Object> addCourse(@RequestBody Course course, @PathVariable int topicId) {
		course.setTopic(new Topic(topicId,""));
		courseService.addCourse(course);;
		logger.info("Course added successfully");
		return new ResponseEntity<>("Course added successfully",HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topic/{id}/courses/{courseId}")
	public ResponseEntity<Object> updateCourse(@RequestBody Course course, @PathVariable int courseId, @PathVariable int id) {
		course.setTopic(new Topic(id,""));
		courseService.updateCourse(course);
		logger.info("Course updated successfully");
		return new ResponseEntity<>("Course updated successfully",HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topic/{id}/courses/{courseId}")
	public ResponseEntity<Object> deleteCourse(@PathVariable int courseId) {
		courseService.deleteCourse(courseId);
		logger.info("Course deleted successfully");
		return new ResponseEntity<>("Course deleted successfully",HttpStatus.OK);
		
	}
}











