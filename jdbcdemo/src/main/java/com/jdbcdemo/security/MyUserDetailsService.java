package com.jdbcdemo.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Map<String, Object> retMap = new HashMap<>();
		GetSavedUser gsu = new GetSavedUser();
		retMap = gsu.getSavedUser(username);
		String id = (String) retMap.get("userCode");
		String psd = (String) retMap.get("psd");

		return new User(id, psd, new ArrayList<>());
	}

}
