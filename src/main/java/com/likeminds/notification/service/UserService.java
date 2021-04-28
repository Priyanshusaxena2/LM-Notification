package com.likeminds.notification.service;

import com.likeminds.notification.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService implements IService<User>{

    private List<User> users;

    public UserService(){
        this.users = new ArrayList<>();
    }

    @Override
    public void add(User user) {
         this.users.add(user);
    }

    public User findByUserName(String userName){
        Optional<User> user = this.users.stream().filter(u ->
                u.getUserName().equalsIgnoreCase(userName)).findAny();
        return user.orElse(null);
    }
}
