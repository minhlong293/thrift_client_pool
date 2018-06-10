package demo.handler;

import demo.thrift.CalcService;
import org.apache.thrift.TException;

public class CalcHandler implements CalcService.Iface {
    @Override
    public String sayHello() throws TException {
        return "Hello World!";
    }

    @Override
    public int add(int a, int b) throws TException {
        return a + b;
    }

    @Override
    public int divide(int a, int b) throws TException {
        return a/b;
    }
}
