package com.github.minhlong293.thrift.common;

import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThriftExceptionHelperTest {

    @Test
    public void isDisconnectedException() {
        Assert.assertFalse(ThriftExceptionHelper.isDisconnectedException(new TException()));
        Assert.assertFalse(ThriftExceptionHelper.isDisconnectedException(new TApplicationException()));
        Assert.assertFalse(ThriftExceptionHelper.isDisconnectedException(new RuntimeException()));
        Assert.assertFalse(ThriftExceptionHelper.isDisconnectedException(new IllegalArgumentException()));
        Assert.assertFalse(ThriftExceptionHelper.isDisconnectedException(new TTransportException(TTransportException.ALREADY_OPEN)));
        Assert.assertTrue(ThriftExceptionHelper.isDisconnectedException(new TTransportException(TTransportException.END_OF_FILE)));
        Assert.assertTrue(ThriftExceptionHelper.isDisconnectedException(new TTransportException(TTransportException.UNKNOWN)));
        Assert.assertTrue(ThriftExceptionHelper.isDisconnectedException(new TTransportException(TTransportException.NOT_OPEN)));
        Assert.assertTrue(ThriftExceptionHelper.isDisconnectedException(new TTransportException(TTransportException.TIMED_OUT)));
    }
}