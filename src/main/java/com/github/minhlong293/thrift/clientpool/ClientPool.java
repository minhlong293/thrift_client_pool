package com.github.minhlong293.thrift.clientpool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.function.BiFunction;

/**
 * An implementation of BaseClientPool.
 *
 * @author minhlong293
 */
public class ClientPool<T extends BaseClient> extends BaseClientPool<T> {
    public ClientPool(GenericObjectPoolConfig poolConfig, String host, int port, BiFunction<String, Integer, T> supplier) {
        this(poolConfig, new ClientFactory<>(host, port, supplier));
    }

    public ClientPool(String host, int port, BiFunction<String, Integer, T> supplier) {
        this(new GenericObjectPoolConfig(), new ClientFactory(host, port, supplier));
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
