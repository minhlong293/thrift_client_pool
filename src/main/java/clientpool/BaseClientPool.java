package clientpool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public abstract class BaseClientPool<T> implements AutoCloseable {
    protected GenericObjectPool<T> internalPool;

    public BaseClientPool(final GenericObjectPoolConfig poolConfig, PooledObjectFactory<T> factory) {
        initPool(poolConfig, factory);
    }
    @Override
    public void close() throws Exception {
        try {
            internalPool.close();
        } catch (Exception e) {
            throw new RuntimeException("Could not close the pool");
        }
    }
    public boolean isClosed() {
        return this.internalPool.isClosed();
    }
    public void initPool(final GenericObjectPoolConfig poolConfig, PooledObjectFactory<T> factory) {
        if (this.internalPool != null) {
            try {
                close();
            } catch (Exception e) {
            }
        }
        this.internalPool = new GenericObjectPool<>(factory, poolConfig);
    }
    public T getObjectFromPool() {
        try {
            return internalPool.borrowObject();
        } catch (Exception e) {
            throw new RuntimeException("Could not borrow object from pool");
        }
    }
    public void returnBrokenResourceObject(final T resource) {
        try {
            internalPool.invalidateObject(resource);
        } catch (Exception e) {
            throw new RuntimeException("Could not return the resource to the pool", e);
        }
    }
    public void returnResource(final T resource) {
        if (resource != null) {
            returnResourceObject(resource);
        }
    }
    public void returnResourceObject(final T resource) {
        if (resource == null) {
            return;
        }
        try {
            internalPool.returnObject(resource);
        } catch (Exception e) {
            throw new RuntimeException("Could not return the resource to the pool", e);
        }
    }
}
