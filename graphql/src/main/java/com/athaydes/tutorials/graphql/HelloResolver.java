package com.athaydes.tutorials.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;

public class HelloResolver implements GraphQLResolver<Hello> {

    public String name( Hello hello ) {
        return hello.getName();
    }

    public String message( Hello hello ) {
        return hello.getMessage();
    }

}
