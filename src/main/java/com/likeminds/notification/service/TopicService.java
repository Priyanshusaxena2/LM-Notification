package com.likeminds.notification.service;

import com.likeminds.notification.model.Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TopicService implements IService<Topic>{

    private List<Topic> topics;

    AsyncService asyncService;

    public TopicService(){
        this.asyncService = new AsyncService();
        this.topics = new ArrayList<>();
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public void add(Topic topic) {
        this.topics.add(topic);
    }

    public Topic findByTopicName(String topicName){
        Optional<Topic> topic = this.topics.stream().filter(t ->
                t.getTopicName().equalsIgnoreCase(topicName)).findAny();
        return topic.orElse(null);
    }

    public void processMessages(){
        Runnable asyncThread = new Runnable() {
            @Override
            public void run() {
                for(Topic topic: getTopics()){
                    topic.broadCast();
                }
            }
        };
        asyncService.submitTask(asyncThread);
    }

}
