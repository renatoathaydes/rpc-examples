package com.athaydes.tutorials.thrift;

import com.athaydes.tutorials.thrift.api.HelloService;
import org.apache.thrift.TException;

public class SimpleHelloService implements HelloService.Iface {
    @Override
    public String sayHello( String name ) throws TException {
        return "Hello " + name;
    }

    @Override
    public String sayHelloAgain( String name ) throws TException {
        return "Hello again " + name;
    }
}
