package xmlrpc.server;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

import java.net.InetAddress;

public class HelloServer {
    public WebServer web_server;
    public HelloServer() {
        try {
            this.web_server = new WebServer(10080,
                    InetAddress.getByAddress(new byte[] { 127, 0, 0, 1 }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initServer() {
        System.out.println("Starting Rpc Server...");
        XmlRpcServer xmlRpcServer = web_server.getXmlRpcServer();
        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        try {
            phm.addHandler("Hello", HelloRpcHandler.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        xmlRpcServer.setHandlerMapping(phm);
        try {
            web_server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Rpc Server started.");
    }

    public static void main(String[] args) {
        HelloServer mySer = new HelloServer();
        mySer.initServer();
    }
}
