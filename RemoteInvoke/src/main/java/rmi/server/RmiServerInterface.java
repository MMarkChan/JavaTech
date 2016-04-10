package rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * defines the interface that is used by the client and implemented by the server.
 * 定义由服务器实现，由客户端使用的接口
 */
public interface RmiServerInterface extends Remote {
    public String getMessage() throws RemoteException;
}
