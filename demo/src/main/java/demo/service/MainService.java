package demo.service;

import demo.handler.CalcHandler;
import demo.thrift.CalcService;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

public class MainService {

    public static final int PORT = 8888;
    private static TThreadedSelectorServer threadedSelectorServer;

    public static void main(String[] args) {
        startService();
    }

    public static void startService() {
        TNonblockingServerTransport trans = null;
        try {
            trans = new TNonblockingServerSocket(PORT);
            TThreadedSelectorServer.Args config = new TThreadedSelectorServer.Args(trans);
            config.processor(new CalcService.Processor<>(new CalcHandler()));
            threadedSelectorServer = new TThreadedSelectorServer(config);
            new Thread(()-> threadedSelectorServer.serve()).start();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
    public static void stopService() {
        threadedSelectorServer.stop();
        System.out.println("Service stopped!");
    }
}
