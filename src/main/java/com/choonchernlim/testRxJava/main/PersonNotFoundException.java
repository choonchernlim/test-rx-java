package com.choonchernlim.testRxJava.main;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(Integer personId) {
        super("Invalid Person ID: " + personId);
    }
}
