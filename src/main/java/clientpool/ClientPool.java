package clientpool;

import client.Client;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class ClientPool extends BaseClientPool<Client> {
    public ClientPool(String host, int port) {
        this(new GenericObjectPoolConfig(), new ClientFactory(host, port));
    }
    public ClientPool(GenericObjectPoolConfig poolConfig, PooledObjectFactory<Client> factory) {
        super(poolConfig, factory);
    }

    @Override
    public Client getObjectFromPool() {
        Client objectFromPool = super.getObjectFromPool();
        objectFromPool.setDatasource(this);
        return objectFromPool;
    }
}
