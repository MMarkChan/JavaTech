/**
 * 基于Socket的低层次Java网络编程
 *
 * Socket通讯
        网络上的两个程序通过一个双向的通讯连接实现数据的交换，这个双向链路的一端称为一个Socket。
     Socket通常用来实现客户方和服务方的连接。Socket是TCP/IP协议的一个十分流行的编程接口，
     一个Socket由一个IP地址和一个端口号唯一确定。
        在传统的UNIX环境下可以操作TCP/IP协议的接口不止Socket一个，Socket所支持的协议种类也不光TCP/IP一种，
     因此两者之间是没有必然联系的。在Java环境下，Socket编程主要是指基于TCP/IP协议的网络编程。

 Socket通讯的一般过程
        使用Socket进行Client/Server程序设计的一般连接过程是这样的：
        Server端Listen(监听)某个端口是否有连接请求，
        Client端向Server端发出Connect(连接)请求，
        Server端向Client端发回Accept（接受）消息，一个连接就建立起来了。
        Server端和Client端都可以通过Send，Write等方法与对方通信。

        对于一个功能齐全的Socket，都要包含以下基本结构，其工作过程包含以下四个基本的步骤：
         （1）创建Socket；
         （2）打开连接到Socket的输入/出流；
         （3）按照一定的协议对Socket进行读/写操作；
         （4）关闭Socket.

 创建Socket
     java在包java.net中提供了两个类Socket和ServerSocket，分别用来表示双向连接的客户端和服务端。
    这是两个封装得非常好的类，使用很方便。其构造方法如下：
     Socket(InetAddress address, int port);
     Socket(InetAddress address, int port, boolean stream);
     Socket(String host, int prot);
     Socket(String host, int prot, boolean stream);
     Socket(SocketImpl impl)
     Socket(String host, int port, InetAddress localAddr, int localPort)
     Socket(InetAddress address, int port, InetAddress localAddr, int localPort)

     ServerSocket(int port);
     ServerSocket(int port, int backlog);
     ServerSocket(int port, int backlog, InetAddress bindAddr)

     其中address、host和port分别是双向连接中另一方的IP地址、主机名和端口号，
     stream指明socket是流socket还是数据报socket，localPort表示本地主机的端口号，
     localAddr和bindAddr是本地机器的地址（ServerSocket的主机地址），impl是socket的父类，
     既可以用来创建serverSocket又可以用来创建Socket。count则表示服务端所能支持的最大连接数。例如：

     Socket client = new Socket("127.0.01.", 80);
     ServerSocket server = new ServerSocket(80);

     注意，在选择端口时，必须小心。每一个端口提供一种特定的服务，只有给出正确的端口，才能获得相应的服务。
        0~1023的端口号为系统所保留，例如http服务的端口号为80,telnet服务的端口号为21,ftp服务的端口号为23,
        所以我们在选择端口号时，最好选择一个大于1023的数以防止发生冲突。
     在创建socket时如果发生错误，将产生IOException，在程序中必须对之作出处理。所以在创建Socket或
     ServerSocket是必须捕获或抛出例外

 */
package net.socketbase;