package com.github.minhlong293.thrift.clientpool;

import org.apache.thrift.TException;
/**
 * Base client class. All clients using for pool must be inherit this class.
 *
 * @author minhlong293
 */
public abstract class BaseClient implements AutoCloseable {
    private BaseClientPool datasource;

    public abstract boolean isConnected();
    public abstract void disconnect();
    //init connection
    public abstract void connect() throws TException;

    protected <T extends BaseClient> void setDatasource(BaseClientPool<T> datasource) {
        this.datasource = datasource;
    }

    @Override
    public void close() {
        if (datasource != null) {
            if (this.isConnected()) {
                this.datasource.returnResource(this);
            } else {
                this.datasource.returnBrokenResourceObject(this);
            }
        } else {
            this.disconnect();
        }
    }

}
