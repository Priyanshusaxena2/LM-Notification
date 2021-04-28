package com.likeminds.notification.model;

public class Message {

    private String id;
    private String topicName;
    private String text;
    private boolean broadCasted;

    public Message(String id, String topicName, String text){
        this.id = id;
        this.topicName = topicName;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isBroadCasted() {
        return broadCasted;
    }

    public void setBroadCasted(boolean broadCasted) {
        this.broadCasted = broadCasted;
    }
}
