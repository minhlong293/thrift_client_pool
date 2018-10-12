package com.github.minhlong293.thrift.common;

import org.apache.thrift.transport.TTransportException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author minhlong293
 */
public class ThriftExceptionHelper {

    public static Set<Integer> THRIFT_EXCEPTION_CAUSE_DISCONNECTED = new HashSet<>(Arrays.asList(
            TTransportException.NOT_OPEN,
            TTransportException.END_OF_FILE,
            TTransportException.TIMED_OUT,
            TTransportException.UNKNOWN
    ));

    public static boolean isDisconnectedException(Exception e) {
        if (e instanceof TTransportException) {
            TTransportException te = (TTransportException) e;
            if (THRIFT_EXCEPTION_CAUSE_DISCONNECTED.contains(te.getType())) {
                return true;
            }
        }
        return false;
    }
}
