package com.athaydes.tutorials.xmlrpc.proxy;

import java.net.MalformedURLException;
import java.net.URL;

public class SimplerClient {

    public interface HandlerApi {
        String sayHello( String name );

        String sayHelloAgain( String name );
    }


    public static void main( String[] args ) throws MalformedURLException {
        HandlerApi handler = ClientProxy.wrap( HandlerApi.class,
                new URL( "http://127.0.0.1:8081" ),
                "Handler" );
        System.out.println( handler.sayHelloAgain( "Joe" ) );
    }

}
