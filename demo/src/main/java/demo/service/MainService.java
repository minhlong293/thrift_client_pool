package demo.service;

import demo.handler.CalcHandler;
import demo.thrift.CalcService;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

public class MainService {
    public static void main(String[] args) {
        TNonblockingServerTransport trans = null;
        try {
            trans = new TNonblockingServerSocket(8888);
            TThreadedSelectorServer.Args config = new TThreadedSelectorServer.Args(trans);
            config.processor(new CalcService.Processor<>(new CalcHandler()));
            TThreadedSelectorServer threadedSelectorServer = new TThreadedSelectorServer(config);
            new Thread(()->threadedSelectorServer.serve()).start();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
