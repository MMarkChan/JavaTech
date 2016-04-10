package xmlrpc.client;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.testng.annotations.Test;

import java.net.URL;

public class HelloClient {
    public Object invoke(String name,Object... args) {
        Object result = "";
        XmlRpcClient client = new XmlRpcClient();
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        try {
            config.setServerURL(new URL("http://localhost:10080"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.setConfig(config);
        try {
            result = client.execute("Hello."+name, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Test
    public void client(){

        HelloClient myTest = new HelloClient();
        Object res = myTest.invoke("sayHello","Chendongming");
        System.out.println(res.toString());

        res = myTest.invoke("getHostname");
        System.out.println(res.toString());
    }
}