package xmlrpc.server;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HelloRpcHandler {
    public String sayHello(String name) {
        return "Hello," + name;
    }
    public String getHostname(){
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
