package thrift.basic;

import org.apache.thrift.TException;

/**
 * Created by Mark on 2016/3/27.
 */
public class HelloWorldImpl implements HelloWorldService.Iface {
    public HelloWorldImpl() {
    }

    @Override
    public String sayHello(String username) throws TException {
        return "Hi," + username + " welcome to my blog www.micmiu.com";
    }

}
