package com.jdbcdemo.jdbcdemo.interfaces;

import com.jdbcdemo.jdbcdemo.dto.BaseOutput;
import com.jdbcdemo.jdbcdemo.dto.EmailRequest;

public interface ISendSimpleEmail {
	
	public BaseOutput sendSimpleMail(EmailRequest emailRequest);

}
