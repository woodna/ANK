package com.ank.dao;

/* 
Nate Wood
HerdPersistenceException
*/

public class HerdPersistenceException extends Exception{

    public HerdPersistenceException(String message){
        super(message);
    }

    public HerdPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}