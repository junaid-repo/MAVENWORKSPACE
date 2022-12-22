package com.system.users.service;

import com.system.users.dto.UserRequest;
import com.system.users.dto.UserResponse;

public interface IUserServices {
	
	public UserResponse createUser(UserRequest request);
	

}
