package com.athaydes.tutorials.xmlrpc;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;

public class Client {

    public static void main( String[] args ) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL( new URL( "http://127.0.0.1:8081" ) );

        XmlRpcClient client = new XmlRpcClient();
        client.setConfig( config );

        Object[] params = { "Joe" };
        String result = ( String ) client.execute( "Handler.sayHelloAgain", params );

        System.out.println( result );
    }

}
