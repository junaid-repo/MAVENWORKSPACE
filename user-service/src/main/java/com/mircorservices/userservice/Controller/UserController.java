package com.mircorservices.userservice.Controller;

import com.mircorservices.userservice.Services.UserService;
import com.mircorservices.userservice.entity.Users;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService serv;
    @PostMapping("/users")
    ResponseEntity<Users> saveUser(@RequestBody Users user){
        Users response = new Users();

        response =serv.saveUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}
