package com.likeminds.notification.service;

import com.likeminds.notification.model.Message;
import com.likeminds.notification.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class MessageService implements IService<Message> {

    private TopicService topicService;
    private List<Message> messages;

    public MessageService(){
        this.topicService = new TopicService();
        this.messages = new ArrayList<>();
    }

    @Override
    public void add(Message message) {
        this.messages.add(message);
    }

    public void addMessage(Message message, Topic topic){
        add(message);
        topic.addMessage(message);
    }
}
