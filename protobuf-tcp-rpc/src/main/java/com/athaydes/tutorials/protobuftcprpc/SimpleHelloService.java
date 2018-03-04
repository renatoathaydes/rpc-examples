package com.athaydes.tutorials.protobuftcprpc;

import java.util.Arrays;
import java.util.List;

public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello( String name ) {
        return "Hello " + name;
    }

    @Override
    public String sayHelloAgain( String name ) {
        return "Hello again " + name;
    }

    @Override
    public List<String> getBallon() {
        return Arrays.asList( "b", "c" );
    }
}
