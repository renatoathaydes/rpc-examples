package com.athaydes.tutorials.xmlrpc.proxy;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.lang.reflect.Proxy;
import java.net.URL;

public class ClientProxy {

    @SuppressWarnings( "unchecked" )
    public static <T> T wrap( Class<T> handlerType, URL serverUrl, String handlerName ) {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL( serverUrl );

        XmlRpcClient client = new XmlRpcClient();
        client.setConfig( config );

        return ( T ) Proxy.newProxyInstance( handlerType.getClassLoader(),
                new Class[]{ handlerType },
                ( proxy, method, args ) -> client.execute( handlerName + "." + method.getName(), args ) );
    }

}
