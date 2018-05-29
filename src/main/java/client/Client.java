package client;

import clientpool.BaseClientPool;

import java.util.concurrent.atomic.AtomicInteger;

public class Client implements AutoCloseable {
    private static AtomicInteger COUNT_INIT = new AtomicInteger(0);
    private String name;
    private String host;
    private int port;
    private BaseClientPool<Client> datasource = null;

    public Client(String host, int port) {
        this.setHost(host);
        this.setPort(port);
        int count = COUNT_INIT.addAndGet(1);
        System.out.println("Create new client. Count " + count);
        this.name = "client " + count;
    }

    public void setDatasource(BaseClientPool<Client> datasource) {
        this.datasource = datasource;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void close() throws Exception {
        if (datasource != null) {
            //if client is disconnected -> datasource.returnBrokenResourceObject(this);
            datasource.returnResourceObject(this);
            System.out.println("Close " + this.name);
        } else {
            // close connection
        }
    }
    public void sayName() {
        System.out.println("Client name " + this.name);
    }
}
