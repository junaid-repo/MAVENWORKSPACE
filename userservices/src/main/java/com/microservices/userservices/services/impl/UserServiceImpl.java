package com.microservices.userservices.services.impl;

import com.microservices.userservices.Repositories.UserRepository;
import com.microservices.userservices.entities.User;
import com.microservices.userservices.exceptions.ResourceNotFoundException;
import com.microservices.userservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {


        String userId= UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getOneUser(String userId) {
        return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with the id "+userId+" is not on the Server"));
    }
}
