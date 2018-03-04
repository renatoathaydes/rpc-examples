package com.athaydes.tutorials.protobuftcprpc;

import java.util.List;

public interface HelloService {
    String sayHello( String name );

    String sayHelloAgain( String name );

    List<String> getBallon();
}
