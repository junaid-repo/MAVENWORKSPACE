package com.microservices.userservices.controller;


import com.microservices.userservices.entities.User;
import com.microservices.userservices.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


 @PostMapping
 public ResponseEntity<User> createUser(@RequestBody User user){

     User users= userService.saveUser(user);
     return ResponseEntity.status(HttpStatus.CREATED).body(users);

    }

 @GetMapping("/{userId}")
 public ResponseEntity<User> getAUser(@PathVariable String userId){
     User user=userService.getOneUser(userId);
     return ResponseEntity.status(HttpStatus.FOUND).body(user);
 }

@GetMapping
 public ResponseEntity<List<User>> getAllUser(){
     List<User> allUsers=userService.getUsers();

     return ResponseEntity.status(HttpStatus.FOUND).body(allUsers);
 }
}
