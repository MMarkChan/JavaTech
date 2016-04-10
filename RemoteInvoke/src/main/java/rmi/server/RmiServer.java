package rmi.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ObjID;
import java.rmi.server.UnicastRemoteObject;

/**
 * listens to RMI requests and implements the interface which is
 * used by the client to invoke remote methods.
 * 监听RMI请求并实现由用户用来调用远程方法的接口
 *
 * unicast,Unicast(单播):在客户端与媒体服务器之间需要建立一个单独的数据通道,
 * 从一台服务器送出的每个数据包只能传送给一个客户机,这种传送方式称为单播
 */
public class RmiServer extends UnicastRemoteObject implements RmiServerInterface {
    public static final String MESSAGE = "Hello World";

    public RmiServer() throws RemoteException {
        //super(0);    // required to avoid the 'rmic' step, see below
    }

    public String getMessage() {
        return MESSAGE;
    }

    public static void main(String args[]) throws Exception {
        System.out.println("RMI server started");

        try { //special exception handler for registry creation
            /**
             * 创建并导出一个在本地主机指定端口上接收请求的Registry实例
             * 这个Registry实例被导出就如同UnicastRemoteObject的静态方法
             * exportObject(Remote,int)被调用并传递这个Registry实例和指定端口作为参数，
             * 此外，Registry实例导出时会带有一个知名的标识符：一个使用ObjID.REGISTRY_ID
             * 值来构造的ObjId实例。
             * */
            LocateRegistry.createRegistry(1099);
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }

        //Instantiate RmiServer

        RmiServer obj = new RmiServer();

        // Bind this object instance to the name "RmiServer"
        /**
         * 重新绑定指定的名称到一个远程对象上，任何跟这个名称已经存在的绑定都会被替换掉
         */
        Naming.rebind("//localhost/RmiServer", obj);
        System.out.println("PeerServer bound in registry");
    }
}