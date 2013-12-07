package com.ssb.service;

import javax.xml.ws.WebFault;

@WebFault(name="exception") 
public class SomeException extends Exception {

    public String contactInfo = "Sacrosanct Blood."; 
    private static final long serialVersionUID = 1L;

    private SomeException() { 
    }

    public SomeException(String message, Throwable cause) { 
        super(message, cause); 
    }

    public SomeException(String message) { 
        super(message); 
    } 
}

