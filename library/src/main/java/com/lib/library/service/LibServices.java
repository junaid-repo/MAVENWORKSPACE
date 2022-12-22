package com.lib.library.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lib.library.dto.AddBookRequest;
import com.lib.library.service.core.CoreLibServiceCall;
import com.lib.library.service.interfaces.functional.AddBookInterface;
import com.lib.library.service.interfaces.functional.CreateLibUsersInterface;

public class LibServices implements AddBookInterface, CreateLibUsersInterface {

	@Override
	public List<Map> addABook(AddBookRequest request) {
		List<Map> response = new ArrayList<>();

		AddBookInterface obj = (AddBookRequest bookObj) -> {

			List<Map> bookList = new ArrayList<>();
			bookList=bookObj.getBookDetails();
			Map<String, Object> retMap = new HashMap<>();
			/*
			 * List<Map> bookList = new LinkedList<>();
			 * 
			 * bookList = (List<Map>) request.get("bookList");
			 */
			List<Map> returnedList = new ArrayList<>();

			CoreLibServiceCall core = new CoreLibServiceCall();

			for (Map tempList : bookList) {

				retMap = core.addBook(tempList);

				returnedList.add(retMap);

			}
			return returnedList;

		};

		response = obj.addABook(request);

		return response;
	}

	@Override
	public Map<String, Object> createLibUsers(Map request) {

		Map<String, Object> response = new HashMap<>();

		CreateLibUsersInterface clu = (Map users) -> {
			CoreLibServiceCall core = new CoreLibServiceCall();
			Map output = new HashMap<>();
			output = core.createLibUsers(users);

			return output;
		};
		response = clu.createLibUsers(request);
		return response;
	}

}
