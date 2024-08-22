package com.kraft.event.exception;

public class FileExtensionNotFoundException extends RuntimeException{
    public FileExtensionNotFoundException(String message){
        super(message);
    }
}
