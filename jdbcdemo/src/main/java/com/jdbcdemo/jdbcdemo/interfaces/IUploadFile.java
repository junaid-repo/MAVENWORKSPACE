package com.jdbcdemo.jdbcdemo.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFile {
	
	public String uploadFile(MultipartFile file);

}
