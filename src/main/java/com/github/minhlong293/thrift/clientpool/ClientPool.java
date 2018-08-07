package com.github.minhlong293.thrift.clientpool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.function.Supplier;

/**
 * An implementation of BaseClientPool.
 *
 * @author minhlong293
 */
public class ClientPool<T extends BaseClient> extends BaseClientPool<T> {
    public ClientPool(Supplier<T> clientSupplier) {
        this(new GenericObjectPoolConfig(), new ClientFactory<>(clientSupplier));
    }
    public ClientPool(GenericObjectPoolConfig poolConfig, Supplier<T> clientSupplier) {
        this(poolConfig, new ClientFactory<>(clientSupplier));
    }

    public ClientPool(GenericObjectPoolConfig poolConfig, PooledObjectFactory<T> factory) {
        super(poolConfig, factory);
    }

    @Override
    public T getObjectFromPool() {
        T objectFromPool = super.getObjectFromPool();
        objectFromPool.setDatasource(this);
        return objectFromPool;
    }
}
