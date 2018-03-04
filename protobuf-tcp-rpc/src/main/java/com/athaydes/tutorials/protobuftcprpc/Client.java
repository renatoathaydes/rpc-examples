package com.athaydes.tutorials.protobuftcprpc;

import com.athaydes.protobuf.tcp.api.RemoteServices;

public class Client {

    public static void main( String[] args ) {
        HelloService helloService = RemoteServices.createClient(
                HelloService.class, "localhost", 8081 );
        System.out.println( helloService.sayHello( "Joe" ) );
        System.out.println( helloService.sayHelloAgain( "Joe" ) );
        System.out.println( helloService.getBallon() );
    }
}
