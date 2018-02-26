package com.athaydes.tutorials.rpc.grpc;

import com.athaydes.tutorials.rpc.grpc.api.GreeterGrpc;
import com.athaydes.tutorials.rpc.grpc.api.Helloworld.HelloReply;
import com.athaydes.tutorials.rpc.grpc.api.Helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;

public class SimpleGreeter extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello( HelloRequest req, StreamObserver<HelloReply> responseObserver ) {
        HelloReply reply = HelloReply.newBuilder().setMessage( "Hello " + req.getName() ).build();
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }

    @Override
    public void sayHelloAgain( HelloRequest req, StreamObserver<HelloReply> responseObserver ) {
        HelloReply reply = HelloReply.newBuilder().setMessage( "Hello again " + req.getName() ).build();
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }
}
