#### Thrift Client Pool (with auto close resource)

A thrift client pool implementation with AutoClosable, make easy for returning client to pool by using try-catch-resource.
#### Features:

- Don't have to worry about connection status: Client which disconnected to server will be released from pool. A new client will be created if getObjectFromPool() is called.
- Don't have to worry about thread-safe: If you use method 2 belows, client objects are thread-safe. Pool object is always thread-safe.    

##### GUIDE (see demo/src/main/java/ for example):
Gradle:
```
//for thrift ver 0.9.3
dependencies {
    compile group: 'com.github.minhlong293', name: 'clientpool', version: '0.9.3-1'
}
//for thrift ver 0.11.0
dependencies {
    compile group: 'com.github.minhlong293', name: 'clientpool', version: '0.11.0'
}
```
#### METHOD 1: Write a wrapper client class yourselves
(see _method1()_ in demo.client.DemoClientPool)

STEP 1: You must to implement BaseClient class to make it can be use with the pool.
In CalcClientImpl.java:
```
public class CalcClientImpl extends BaseClient {
   // this class has its own internal client which used to call thrift server  
}
...
```
STEP 2: Use ClientPool<T> for create a new pool instance.
In DemoClientPool.java:
```
ClientPool<CalcClientImpl> pool = new ClientPool<>("localhost", 8888, CalcClientImpl::new);
```
STEP 3: Call pool.getObjectFromPool() in try-catch-resource block to get the client.
In DemoClientPool.java:
```
//the pool object is thread-safe so you can use only one instance in your program  
try (CalcClientImpl calcClient = pool.getObjectFromPool()) {
    calcClient.sayHello();
}
```

#### METHOD 2: Using ClientWrapper class
(see _method2()_ in demo.client.DemoClientPool)

Class com.github.minhlong293.thrift.clientwrapper.ClientWrapper takes care all implementation of methods from BaseClient. It uses a Java 
[Proxy](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Proxy.html) object for wrapping the real client, so we can handle all exceptions and
 make all methods synchronized.
 
```
//Create pool
ClientPool<ClientWrapper<Iface, Client>> clientPool = new ClientPool<>(
                LOCALHOST,
                PORT,
                (host, port) -> new ClientWrapper<>(host, port,
                        (h, p) -> new TFramedTransport(new TSocket(h, p, 500)),
                        (trans) -> {
                            TProtocol protocol = new TBinaryProtocol(trans);
                            return new Client(protocol);
                        },
                        Iface.class
                ));
                
// Get client
try (ClientWrapper<Iface, Client> clientWrapper = clientPool.getObjectFromPool()) {
    Iface client = clientWrapper.getClient();
    // the client object is an Iface, so you can call all functions define in Iface interface.
    // it is thread-safe as wrapped by InvocationHandler, all methods is synchronized
}  
```