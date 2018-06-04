package demo.client;

import demo.thrift.CalcService;
import com.github.minhlong293.thrift.clientpool.BaseClient;
import com.github.minhlong293.thrift.common.ThriftExceptionHelper;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This class wraps an internal client and implements methods from BaseClient for pooling.
 * All wrapper methods must be synchronize.
 *
 * @author minhlong293
 */
public class CalcClientImpl extends BaseClient {
    private final String host;
    private final int port;
    private AtomicBoolean isConnected = new AtomicBoolean(false);
    private TTransport trans;

    // internal client to call server
    private CalcService.Client internalClient;

    public CalcClientImpl(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            connect();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isConnected() {
        return isConnected.get();
    }

    @Override
    public void disconnect() {
        trans.close();
        isConnected.set(false);
    }

    @Override
    public void connect() throws TException {
        synchronized (this) {
            trans = new TFramedTransport(new TSocket(this.host, this.port));
            trans.open();
            TProtocol proto = new TBinaryProtocol(trans);
            this.internalClient = new CalcService.Client(proto);
            this.isConnected.set(true);
        }
    }
    private void checkTException(TException e) {
        if (ThriftExceptionHelper.isDisconnectedException(e)) {
            isConnected.set(false);
        }
    }

    //Wrapper methods

    public synchronized int add(int a, int b, int defaultValue) {
        try {
            return internalClient.add(a, b);
        } catch (TException e) {
            //check if this exception is a disconnected exception
            checkTException(e);
            e.printStackTrace();
        }
        return defaultValue;
    }
    public synchronized void sayHello() {
        try {
            System.out.println(internalClient.sayHello());
        } catch (TException e) {
            //check if this exception is a disconnected exception
            checkTException(e);
            e.printStackTrace();
        }
    }
}
