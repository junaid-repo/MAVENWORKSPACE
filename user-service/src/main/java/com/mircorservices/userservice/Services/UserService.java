package com.mircorservices.userservice.Services;

import com.mircorservices.userservice.Repositories.UserSaveRepository;
import com.mircorservices.userservice.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserSaveRepository userSaveRepo;


    public Users saveUser(Users user) {

        return userSaveRepo.save(user);
    }
}
