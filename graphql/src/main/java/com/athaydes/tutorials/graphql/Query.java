package com.athaydes.tutorials.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {

    public Hello sayHello( String name ) {
        return new Hello( name, "Hello " + name );
    }

    public Hello sayHelloAgain( String name ) {
        return new Hello( name, "Hello again " + name );
    }

}
