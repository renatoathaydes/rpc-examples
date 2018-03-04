namespace java com.athaydes.tutorials.thrift.api

service HelloService {
    string sayHello(1:string name)
    string sayHelloAgain(1:string name)
}
