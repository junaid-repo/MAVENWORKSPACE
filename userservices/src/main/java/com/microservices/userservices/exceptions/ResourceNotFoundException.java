package com.microservices.userservices.exceptions;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(){
        super("Resource not found in the server !!!");
    }

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
