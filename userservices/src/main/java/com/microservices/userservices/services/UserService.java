package com.microservices.userservices.services;

import com.microservices.userservices.entities.User;

import java.util.List;

public interface UserService {

    //save users
    User saveUser(User user);

    //getAllUsers

    List<User> getUsers();

    User getOneUser(String userId);
}

