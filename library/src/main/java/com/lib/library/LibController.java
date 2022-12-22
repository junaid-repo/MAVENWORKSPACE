package com.lib.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lib.library.dto.AddBookRequest;
import com.lib.library.service.LibServices;
import com.lib.library.service.interfaces.functional.AddBookInterface;
import com.lib.library.service.interfaces.functional.CreateLibUsersInterface;

@Controller
@ResponseBody
public class LibController {

	@PostMapping("registerLibMember")
	Map<String, Object> registerUser(@RequestBody Map userDetails) {

		LocalDate localDate = LocalDate.now().plusYears(2);

		Map<String, Object> retMap = new HashMap<>();

		CreateLibUsersInterface cl = new LibServices();
		retMap = cl.createLibUsers(userDetails);
		/*
		 * retMap.put("userCode", "LIB00324"); retMap.put("validTill", localDate);
		 */
		return retMap;
	}

	@PostMapping("addBooks")
	List addABook(@RequestBody AddBookRequest bookDetails) {
		List<Map> addedBookDetails = new ArrayList<>();
		Map<String, Object> retMap = new HashMap<>();

		AddBookInterface lib = new LibServices();
		addedBookDetails = lib.addABook(bookDetails);

		return addedBookDetails;
	}

}
