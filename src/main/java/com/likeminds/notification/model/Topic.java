package com.likeminds.notification.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Topic {

    private String topicName;
    private List<User> subscribedUsers;
    private List<Message> messages;


    public Topic(String topicName){
        this.topicName = topicName;
        this.subscribedUsers = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<User> getSubscribedUsers() {
        return subscribedUsers;
    }

    public void setSubscribedUsers(List<User> subscribedUsers) {
        this.subscribedUsers = subscribedUsers;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addUser(User user){
       this.subscribedUsers.add(user);
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }

    public void broadCast(){
        List<Message> messagesToBroadCast = this.messages.stream().filter(m ->
                !m.isBroadCasted()).collect(Collectors.toList());
        for(Message message: messagesToBroadCast){
            for(User user: this.subscribedUsers){
                user.broadCast(message);
            }
            message.setBroadCasted(true);
        }
    }

}
