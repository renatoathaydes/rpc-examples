package com.athaydes.tutorials.graphql;

public class Hello {

    private final String name;
    private final String message;

    public Hello( String name, String message ) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
