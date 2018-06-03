package longhm.common.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author longhm
 */
public class ThriftExceptionHelper {

    public static Set<Integer> THRIFT_EXCEPTION_CAUSE_DISCONNECTED = createSet(
            TTransportException.NOT_OPEN,
            TTransportException.END_OF_FILE,
            TTransportException.TIMED_OUT,
            TTransportException.UNKNOWN
    );

    private static <V> Set<V> createSet(V... vArray) {
        Set<V> set = new HashSet<>();
        for (V v : vArray) {
            set.add(v);
        }
        return set;
    }

    public static boolean isDisconnectedException(Exception e) {
        if (e instanceof TException) {
            TTransportException te = (TTransportException) e;
            if (THRIFT_EXCEPTION_CAUSE_DISCONNECTED.contains(te.getType())) {
                return true;
            }
        }
        return false;
    }
}
