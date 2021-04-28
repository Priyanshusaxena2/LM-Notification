package com.likeminds.notification.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userName;
    private NotificationEnum.UserRole role;
    private List<Topic> subscribedTopics;

    public User(String userName, NotificationEnum.UserRole role){
        this.userName = userName;
        this.role = role;
        this.subscribedTopics = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public NotificationEnum.UserRole getRole() {
        return role;
    }

    public void setRole(NotificationEnum.UserRole role) {
        this.role = role;
    }

    public List<Topic> getSubscribedTopics() {
        return subscribedTopics;
    }

    public void setSubscribedTopics(List<Topic> subscribedTopics) {
        this.subscribedTopics = subscribedTopics;
    }

    public void addTopic(Topic topic){
        this.subscribedTopics.add(topic);
    }

    public void broadCast(Message message){
        System.out.println("topic :" + message.getTopicName()+
                ", message: " + message.getText() + ", sentTo: " + this.getUserName());
    }
}
