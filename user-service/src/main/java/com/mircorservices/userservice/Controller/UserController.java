package com.mircorservices.userservice.Controller;

import com.mircorservices.userservice.Services.UserService;
import com.mircorservices.userservice.VO.UserAndDepartmentDetails;
import com.mircorservices.userservice.entity.Users;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/users/{id}")
    ResponseEntity<UserAndDepartmentDetails> getUserWithDeptId(@PathVariable Integer id){
        UserAndDepartmentDetails response = new UserAndDepartmentDetails();
        response=serv.getUserNDeptDetails(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }
}
