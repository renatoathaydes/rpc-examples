package com.athaydes.tutorials.rpc.grpc;

import com.athaydes.tutorials.rpc.grpc.api.GreeterGrpc;
import com.athaydes.tutorials.rpc.grpc.api.GreeterGrpc.GreeterBlockingStub;
import com.athaydes.tutorials.rpc.grpc.api.Helloworld.HelloReply;
import com.athaydes.tutorials.rpc.grpc.api.Helloworld.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {

    public static void main( String[] args ) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress( "127.0.0.1", 8081 )
                .usePlaintext( true ).build();
        GreeterBlockingStub greeter = GreeterGrpc.newBlockingStub( channel );

        HelloRequest joe = HelloRequest.newBuilder().setName( "Joe" ).build();
        HelloRequest mary = HelloRequest.newBuilder().setName( "Mary" ).build();

        HelloReply joesReply = greeter.sayHello( joe );
        HelloReply marysReply = greeter.sayHello( mary );

        System.out.println( joesReply.getMessage() );
        System.out.println( marysReply.getMessage() );
    }

}
