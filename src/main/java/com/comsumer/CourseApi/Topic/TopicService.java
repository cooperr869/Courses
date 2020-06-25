package com.comsumer.CourseApi.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicR;
	
	private List<Topic> topic = new ArrayList<>(Arrays.asList(
			new Topic(1,"name1"),
			new Topic(2,"name2"),
			new Topic(3,"name3")
			));
	
	public List<Topic> getAllTopics() {
		List<Topic> topic=new ArrayList<>();
		topicR.findAll()
		.forEach(topic::add);;
		return topic;
		//return topic;
	}
	
	/**public Topic getTopic(int id) {
		
		return topic.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}**/

	public void addTopic(Topic topic2) {
		//topic.add(topic2);
		topicR.save(topic2);
		
	}

	public void updateTopic(int id, Topic topic2) {
		/*for(int i=0; i<topic.size();i++) {
			Topic t=topic.get(i);
			if(t.getId()==id) {
				topic.set(id, topic2);
			}
		}*/
		topicR.save(topic2);
		
	}

	public void deleteTopic(int id) {
		//topic.remove(id);
		topicR.deleteById(id);
	}
	
	
	
}
