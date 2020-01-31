/**
 * @author Prabu
 * @date Feb 15, 2012
 */
package com.vaannila;

public class HelloWorld {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void display() {
        System.out.println(message);
    }
}
