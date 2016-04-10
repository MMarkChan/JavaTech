package rmi.client;

import org.testng.annotations.Test;
import rmi.server.RmiServerInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * this is the client which gets the reference (a proxy)
 * to the remote object living on the server and
 * invokes its method to get a message. If the server object
 * implemented java.io.Serializable instead of java.rmi.Remote,
 * it would be serialized and passed to the client as a value.
 * 获取存活在服务器上的远程对象的引用(也叫代理)。如果服务器上的远程对象实现了
 * java.io.Serializable接口而不是java.rmi.Remote接口，则这个远程对象会被序列化并作为一个值
 * 传递给客户端。
 */
public class RmiClient {
    @Test
    public void client() throws RemoteException, NotBoundException, MalformedURLException {
        RmiServerInterface obj = (RmiServerInterface) Naming.lookup("//localhost/RmiServer");
        System.out.println(obj.getMessage());
    }
}