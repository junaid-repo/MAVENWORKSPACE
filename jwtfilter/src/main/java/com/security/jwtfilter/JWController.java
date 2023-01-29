package com.security.jwtfilter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JWController {
	@RequestMapping({ "/hello" })
	public String hello() {
		return "Hello There";
	}

}
