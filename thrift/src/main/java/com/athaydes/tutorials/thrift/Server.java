package com.athaydes.tutorials.thrift;

import com.athaydes.tutorials.thrift.api.HelloService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class Server {

    public static void main( String[] args ) {
        try {
            TServerSocket serverTransport = new TServerSocket( 7911 );

            HelloService.Processor processor = new HelloService.Processor<>( new SimpleHelloService() );

            TServer server = new TThreadPoolServer( new TThreadPoolServer.Args( serverTransport ).
                    processor( processor ) );
            server.serve();
        } catch ( TTransportException e ) {
            e.printStackTrace();
        }
    }

}
