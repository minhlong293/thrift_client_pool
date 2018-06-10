package testclient;

import com.github.minhlong293.thrift.clientpool.ClientPool;
import com.github.minhlong293.thrift.clientwrapper.ClientWrapper;
import com.github.minhlong293.thrift.common.ThriftExceptionHelper;
import demo.service.MainService;
import demo.thrift.CalcService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClientPool {
    private static ClientPool<ClientWrapper<CalcService.Iface, CalcService.Client>> pool = new ClientPool<>("localhost", MainService.PORT,
            (host, port) -> new ClientWrapper<>(
                    host,
                    port,
                    (h, p) -> new TFramedTransport(new TSocket(h, p, 500)),
                    (trans) -> {
                        TProtocol proto = new TBinaryProtocol(trans);
                        return new CalcService.Client(proto);
                    },
                    CalcService.Iface.class
            ));

    @BeforeClass
    public static void startService() {
        MainService.startService();
    }

    @AfterClass
    public static void stopService() {
        MainService.stopService();
    }

    @Test
    public void testException() {
        try (ClientWrapper<CalcService.Iface, CalcService.Client> clientWrapper = pool.getObjectFromPool()) {
            clientWrapper.getClient().divide(1, 0);
            Assert.fail();
        } catch (TException e) {
            e.printStackTrace();
            Assert.assertTrue(ThriftExceptionHelper.isDisconnectedException(e));
        }
    }

    @Test
    public void testMultiThread() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Callable<Void>> listJob = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            listJob.add(() -> {
                try (ClientWrapper<CalcService.Iface, CalcService.Client> clientWrapper = pool.getObjectFromPool()) {
                    Assert.assertEquals(finalI + 1, clientWrapper.getClient().add(1, finalI));
                } catch (TException e) {
                    e.printStackTrace();
                    Assert.fail();
                }
                return null;
            });
        }

        try {
            executorService.invokeAll(listJob);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
