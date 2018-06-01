package longhm.clientpool;

import org.apache.thrift.TException;

public abstract class BaseClient implements AutoCloseable {
    private BaseClientPool datasource;

    public abstract boolean isConnected();
    public abstract void disconnect();

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
