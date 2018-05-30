package client;

import clientpool.BaseClient;
import longhm.common.thrift.ReturnCode;
import longhm.dal.thrift.DMPDALService;
import longhm.dal.thrift.MultiTagResult;
import longhm.dal.thrift.TagDB;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DALClient extends BaseClient {
    private static AtomicInteger OBJECT_COUNT = new AtomicInteger(0);
    private String host;
    private int port;
    private TTransport trans;
    private DMPDALService.Client internalClient;
    private AtomicBoolean isConnected = new AtomicBoolean(false);
    public Set<Integer> THRIFT_EXCEPTION_CAUSE = createSet(
            TTransportException.NOT_OPEN,
            TTransportException.END_OF_FILE,
            TTransportException.TIMED_OUT,
            TTransportException.UNKNOWN
    );

    private <V> Set<V> createSet(V... vArray) {
        Set<V> set = new HashSet<>();
        for (V v : vArray) {
            set.add(v);
        }
        return set;
    }
    public DALClient(String host, int port) {
        System.out.println("Create object!");
        this.host = host;
        this.port = port;
        OBJECT_COUNT.addAndGet(1);
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't connect");
        }
    }

    @Override
    public boolean isConnected() {
        return this.isConnected.get();
    }

    @Override
    public void disconnect() {
        if (isConnected()) {
            trans.close();
            isConnected.set(false);
        }
    }

    @Override
    public void connect() throws TException {
        synchronized (this) {
            if (!this.isConnected()) {
                trans = new TFramedTransport(new TSocket(this.host, this.port, 500));
                trans.open();
                TProtocol protocol = new TBinaryProtocol(trans);
                this.internalClient = new DMPDALService.Client(protocol);
                this.isConnected.set(true);
                System.out.println("Connected!");
            }
        }
    }
    public synchronized MultiTagResult getMultiTags(List<Integer> tagIdList) {
        try {
            return internalClient.getMultiTags(tagIdList);
        } catch (TException e) {
            checkConnectError(e);
        }
        return null;
    }
    public synchronized ReturnCode putTags(TagDB tag) {
        try {
            return internalClient.addTag(tag);
        } catch (TException e) {
            checkConnectError(e);
        }
        return null;
    }
    private void checkConnectError(TException e) {
        if (isConnected.get()) {
            TTransportException te = (TTransportException) e;
            if (THRIFT_EXCEPTION_CAUSE.contains(te.getType())) {
                isConnected.set(false);
            }
        }
    }

    public static int getCount() {
        return OBJECT_COUNT.get();
    }

    protected void finalize() {
        System.out.println("Destroy object. Count " + OBJECT_COUNT.decrementAndGet());
    }
}
