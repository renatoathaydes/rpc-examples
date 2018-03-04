package com.athaydes.tutorials.protobuftcprpc;

import com.athaydes.protobuf.tcp.api.RemoteServices;

import java.io.Closeable;

public class Server {

    public static void main( String[] args ) throws Exception {
        Closeable server = RemoteServices.provideService(
                new SimpleHelloService(), 8081, HelloService.class );

        System.out.println( "Type something to stop the server" );
        System.in.read();
        server.close();
    }

}
