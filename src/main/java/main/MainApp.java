package main;

import client.Client;
import clientpool.ClientPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        ClientPool clientPool = new ClientPool("host", 8888);
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 80; i++) {
            executorService.submit(() -> {
                testPool(clientPool);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(10000);
    }

    private static void testPool(ClientPool clientPool) {
        System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        try (Client client = clientPool.getObjectFromPool()) {
            client.sayName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
