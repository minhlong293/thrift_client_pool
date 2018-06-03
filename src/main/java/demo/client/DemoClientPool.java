package demo.client;

import longhm.clientpool.ClientPool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DemoClientPool {
    public static void main(String[] args) {
        ClientPool<CalcClientImpl> pool = new ClientPool<>("localhost", 8888, CalcClientImpl::new);

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
