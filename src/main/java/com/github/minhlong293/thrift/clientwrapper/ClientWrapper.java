package com.github.minhlong293.thrift.clientwrapper;

import com.github.minhlong293.thrift.clientpool.BaseClient;
import com.github.minhlong293.thrift.common.ThriftExceptionHelper;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ClientWrapper<T, K extends T> extends BaseClient {
    private final String host;
    private final int port;
    private K target;
    private Class iFaceClazz;
    private T clientInvocationHandler;
    private TTransport transport;
    private final BiFunction<String, Integer, TTransport> transportSupplier;
    private final Function<TTransport, K> clientSupplier;
    private AtomicBoolean isConnected = new AtomicBoolean(false);

    public ClientWrapper(String host,
                         int port,
                         BiFunction<String, Integer, TTransport> transportSupplier,
                         Function<TTransport, K> clientSupplier,
                         Class iFaceClazz) {
        this.host = host;
        this.port = port;
        this.transportSupplier = transportSupplier;
        this.clientSupplier = clientSupplier;
        this.iFaceClazz = iFaceClazz;
        try {
            connect();
        } catch (TException e) {
            this.isConnected.set(false);
        }
    }

    public T getClient() {
        return this.clientInvocationHandler;
    }

    @Override
    public boolean isConnected() {
        return this.isConnected.get();
    }

    @Override
    public void disconnect() {
        this.transport.close();
        this.isConnected.set(false);
    }

    @Override
    public void connect() throws TException {
        synchronized (this) {
            if (!this.isConnected()) {
                this.transport = this.transportSupplier.apply(this.host, this.port);
                this.transport.open();
                this.target = this.clientSupplier.apply(transport);
                this.clientInvocationHandler = (T) Proxy.newProxyInstance(ClientWrapper.class.getClassLoader(),
                        new Class[]{this.iFaceClazz},
                        new ClientInvocationHandler<>(this.target));
                this.isConnected.set(true);
            }
        }
    }

    private class ClientInvocationHandler<T> implements InvocationHandler {
        private T target;

        ClientInvocationHandler(T target) {
            this.target = target;
        }

        private void checkTException(TException e) {
            if (ThriftExceptionHelper.isDisconnectedException(e)) {
                ClientWrapper.this.isConnected.set(false);
            }
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (!ClientWrapper.this.isConnected()) throw new TTransportException();
            synchronized (target) {
                try {
                    return method.invoke(target, args);
                } catch (InvocationTargetException e) {
                    if (e.getTargetException() instanceof TException) {
                        checkTException((TException) e.getTargetException());
                    }
                }
            }
            throw new TTransportException();
        }
    }
}
