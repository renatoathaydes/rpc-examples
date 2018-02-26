package com.athaydes.tutorials.rpc.grpc;

import io.grpc.ServerBuilder;

import java.io.IOException;

public class Server {

    public static void main( String[] args )
            throws IOException, InterruptedException {
        io.grpc.Server server = ServerBuilder.forPort( 8081 )
                .addService( new SimpleGreeter() )
                .build();
        server.start().awaitTermination();
    }

}
