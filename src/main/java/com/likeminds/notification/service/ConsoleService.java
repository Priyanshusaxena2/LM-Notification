package com.likeminds.notification.service;

import com.likeminds.notification.model.NotificationEnum;
import com.likeminds.notification.model.Message;

import com.likeminds.notification.model.Subscription;
import com.likeminds.notification.model.Topic;
import com.likeminds.notification.model.User;

public class ConsoleService {

    private UserService userService;
    private TopicService topicService;
    private SubscriptionService subscriptionService;
    private MessageService messageService;

    public ConsoleService(){
        this.userService = new UserService();
        this.topicService = new TopicService();
        this.subscriptionService = new SubscriptionService();
        this.messageService = new MessageService();
    }

    public void processCommand(String commandInput){
        String[] commandData = commandInput.split(" ");

        switch (NotificationEnum.Commands.valueOf(commandData[0])){
            case addUser:
                addUser(commandData[1], commandData[2]);
                break;
            case addTopic:
                addTopic(commandData[1], commandData[2]);
                break;
            case subscribeTopic:
                subscribeTopic(commandData[1], commandData[2]);
                break;
            case postEvent:
                postEvent(new Message(commandData[1], commandData[2], commandData[3]));
                break;
            case processMessages:
                processMessages();
                break;
            case exit:
                System.exit(0);
        }

    }

    private void addUser(String userName, String role){
        this.userService.add(new User(userName, NotificationEnum.UserRole.valueOf(role)));
    }

    private void addTopic(String topicName, String userName){
        User user = this.userService.findByUserName(userName);
        if(user.getRole() == NotificationEnum.UserRole.Admin){
            this.topicService.add(new Topic(topicName));
        }
    }


    private void subscribeTopic(String topicName,String userName){
        Topic topic = this.topicService.findByTopicName(topicName);
        User user = this.userService.findByUserName(userName);
        this.subscriptionService.add(new Subscription(user, topic));
    }

    private void postEvent(Message message){
        Topic topic = this.topicService.findByTopicName(message.getTopicName());
        this.messageService.addMessage(message, topic);
    }

    private void processMessages(){
        this.topicService.processMessages();
    }
}
