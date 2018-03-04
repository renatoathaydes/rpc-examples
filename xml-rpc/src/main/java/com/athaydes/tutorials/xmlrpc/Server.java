package com.athaydes.tutorials.xmlrpc;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class Server {

    public static void main( String[] args ) throws XmlRpcException, IOException {
        PropertyHandlerMapping mapping = new PropertyHandlerMapping();
        mapping.addHandler( "Handler", Handler.class );
        WebServer server = new WebServer( 8081 );
        server.getXmlRpcServer().setHandlerMapping( mapping );
        server.start();
    }
}
