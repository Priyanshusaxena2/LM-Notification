package com.likeminds.notification.model;

public class Subscription {

    private User user;
    private Topic topic;

    public Subscription(User user, Topic topic){
        this.topic = topic;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
