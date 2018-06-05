#### Thrift Client Pool (with auto close resource)

A thrift client pool implementation with AutoClosable, make easy for returning client to pool by using try-catch-resource.
 

##### GUIDE (see demo/src/main/java/ for example):
Gradle (for thrift ver 0.9.3):
```
dependencies {
    compile group: 'com.github.minhlong293', name: 'clientpool', version: '0.9.3'
}
```

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