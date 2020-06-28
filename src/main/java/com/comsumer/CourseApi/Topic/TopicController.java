package com.comsumer.CourseApi.Topic;



import java.util.List;
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



@RestController
public class TopicController {

	private static final Logger logger = LoggerFactory.getLogger(TopicController.class);
	@Autowired	
	TopicService topicService;
	@RequestMapping("/topic")
	public List<Topic> getTopics(){
		logger.info("Request to get all topics");
		return topicService.getAllTopics();
	}
	
	/**@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}**/
	
	@RequestMapping(method=RequestMethod.POST,value="/topic")
	public ResponseEntity<Object> addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		logger.info("Topic added successfully");
		return new ResponseEntity<>("Topic added successfully",HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topic/{id}")
	public ResponseEntity<Object> updateTopic(@RequestBody Topic topic, @PathVariable int id) {
		topicService.updateTopic(id,topic);
		logger.info("Topic updated successfully");
		return new ResponseEntity<>("Topic updated successfully",HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topic/{id}")
	public ResponseEntity<Object> deleteTopic(@PathVariable int id) {
		topicService.deleteTopic(id);
		logger.info("Topic deleted successfully");
		return new ResponseEntity<>("Topic is deleted successfully",HttpStatus.OK);
		
	}
}











