package com.lib.library.service.interfaces.functional;

import java.util.Map;

@FunctionalInterface
public interface CreateLibUsersInterface {
	
	public Map<String, Object> createLibUsers(Map request);

}
