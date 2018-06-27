package demo.client;

import com.github.minhlong293.thrift.clientpool.ClientPool;
import com.github.minhlong293.thrift.clientwrapper.ClientWrapper;
import demo.service.MainService;
import demo.thrift.CalcService.Client;
import demo.thrift.CalcService.Iface;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DemoClientPool {

    public static final String LOCALHOST = "localhost";

    public static void main(String[] args) {
//        method1();
        method2();
    }

    private static void method2() {
        ClientPool<ClientWrapper<Iface, Client>> clientPool = new ClientPool<>(
                LOCALHOST,
                MainService.PORT,
                (host, port) -> new ClientWrapper<>(host, port,
                        (h, p) -> new TFramedTransport(new TSocket(h, p, 500)),
                        (trans) -> {
                            TProtocol protocol = new TBinaryProtocol(trans);
                            return new Client(protocol);
                        },
                        Iface.class
                ));
        Executor executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                // You can use try-catch-resource block since BaseClient implements AutoCloseable.
                // Client will auto returned to the pool.
                System.out.println("Num objects idle " + clientPool.getNumIdle());
                try (ClientWrapper<Iface, Client> clientWrapper = clientPool.getObjectFromPool()) {
                    try {
                        System.out.println(clientWrapper.getClient().sayHello());
                    } catch (TException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private static void method1() {
        ClientPool<CalcClientImpl> pool = new ClientPool<>(LOCALHOST, MainService.PORT, CalcClientImpl::new);

        Executor executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                // You can use try-catch-resource block since BaseClient implements AutoCloseable.
                // Client will auto returned to the pool.
                System.out.println("Num objects idle " + pool.getNumIdle());
                try (CalcClientImpl calcClient = pool.getObjectFromPool()) {
                    calcClient.sayHello();
                }
            });
        }
    }
}
