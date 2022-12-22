package com.system.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.users.dto.UserRequest;
import com.system.users.dto.UserResponse;
import com.system.users.service.IUserServices;
//import com.system.users.service.UserServicesImpl;

@RestController
public class UserController {

	@GetMapping(value = "/user/createUser")
	UserResponse createUser(@RequestBody UserRequest request) {
		UserResponse response = new UserResponse();

		//UserServicesImpl usr = new UserServicesImpl();

		//response = usr.createUser(request);

		return response;
	}
}
