package main;

import client.DALClient;
import clientpool.ClientPool;
import longhm.dal.thrift.MultiTagResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {

    public static final String HOST = "10.60.88.16";
    public static final int PORT = 9100;

    public static void main(String[] args) throws InterruptedException {
        List<Integer> idList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            idList.add(i);
        }

        ClientPool<DALClient> dalClientPool = new ClientPool<>(HOST, PORT, DALClient::new);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                try (DALClient dalClient = dalClientPool.getObjectFromPool()) {
                    MultiTagResult multiTags = dalClient.getMultiTags(idList);
                    System.out.println(multiTags.getReturnCode().name());
                    System.out.println("Count objects " + DALClient.getCount());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread.sleep(90000);
        System.out.println("Count objects " + DALClient.getCount());
        System.out.println(dalClientPool.getNumActive());
        System.out.println(dalClientPool.getNumIdle());
        System.out.println(dalClientPool.getNumWaiters());

        System.gc();
    }
}
