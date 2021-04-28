package com.likeminds.notification.service;

import com.likeminds.notification.model.Subscription;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionService implements IService<Subscription>{

    private List<Subscription> subscriptions;

    public SubscriptionService(){
        this.subscriptions = new ArrayList<>();
    }

    @Override
    public void add(Subscription subscription) {
        this.subscriptions.add(subscription);
        subscription.getTopic().addUser(subscription.getUser());
        subscription.getUser().addTopic(subscription.getTopic());
    }
}
