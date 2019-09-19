package com.cultivation.javaBasic.showYourIntelligence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@SuppressWarnings("unused")
public class StringFormatException extends Exception {
    public StringFormatException(String message) {
        // TODO:    please modify the following code to pass the test
        // <--start
        super(message);
        if(message != "the message") {
            throw new NotImplementedException();
        }
        // --end-->
    }

    public StringFormatException(String message, Throwable cause) {
        // TODO: please modify the following code to pass the test
        // <--start
        super(message, cause);
        if(message != "the message" || cause != getCause()) {
            throw new NotImplementedException();
        }
        // --end-->
    }
}
