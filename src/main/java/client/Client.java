package client;

import clientpool.BaseClient;
import org.apache.thrift.TException;

public class Client extends BaseClient {

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public void disconnect() {

    }

    @Override
    public void connect() throws TException {

    }
}
