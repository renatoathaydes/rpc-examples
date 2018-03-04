package com.athaydes.tutorials.thrift;

import com.athaydes.tutorials.thrift.api.HelloService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;

public class Client {

    public static void main( String[] args ) throws Exception {
        TSocket tSocket = new TSocket( "localhost", 7911 );
        tSocket.open();

        TProtocol tProtocol = new TBinaryProtocol( tSocket );

        HelloService.Client client = new HelloService.Client( tProtocol );

        System.out.println( client.sayHello( "Mary" ) );
        System.out.println( client.sayHelloAgain( "Mary" ) );

        tSocket.close();
    }

}
