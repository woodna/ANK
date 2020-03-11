package com.ank.dao;

/* 
Nate Wood
NoSuchHerdException
*/

public class NoSuchHerdException extends Exception{

    public NoSuchHerdException(String message) {
        super(message);
    }

    public NoSuchHerdException(String message, Throwable cause) {
        super(message, cause);
    }
}