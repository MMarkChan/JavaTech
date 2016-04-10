package hessian.client;
import com.caucho.hessian.client.HessianProxyFactory;
import hessian.server.BasicAPI;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
public class HessianClient {
    @Test
    public void client(){
        String url = "http://127.0.0.1/hessian";

        HessianProxyFactory factory = new HessianProxyFactory();
        BasicAPI basic = null;
        try {
            basic = (BasicAPI) factory.create(BasicAPI.class, url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println("hello(): " + basic.hello());
    }
}
