package clientpool;

import client.Client;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;

public class ClientFactory implements PooledObjectFactory<Client> {
    private String host;
    private int port;

    public ClientFactory(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public PooledObject<Client> makeObject() throws Exception {
        return new DefaultPooledObject<Client>(new Client(host, port));
    }

    @Override
    public void destroyObject(PooledObject<Client> p) throws Exception {
        //TODO: disconnect client from host
        Client object = p.getObject();
        // object.disconnect
    }

    @Override
    public boolean validateObject(PooledObject<Client> p) {
        //TODO: Ensures that the instance is safe to be returned by the pool. (how? check connection?)
        return true;
    }

    @Override
    public void activateObject(PooledObject<Client> p) throws Exception {
        // Reinitialize an instance to be returned by the pool.
    }

    @Override
    public void passivateObject(PooledObject<Client> p) throws Exception {
        // Uninitialize an instance to be returned to the idle object pool.
    }
}
