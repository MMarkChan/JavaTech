package javanio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Mark on 2016/3/18.
 */
public class ServerSocketChannelTest {
    @Test
    public void serverSocketChannel() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        while(true){

     /*
     * serverSocketChannel.accept()
     * 如果没有挂起的连接，且这个Channel处于非阻塞模式，则会立即返回null；
     * 如果处于阻塞模式它会无限阻塞下去，直到有新连接到来，或发生I/O错误。

     * 此方法返回的Socket通道会处于阻塞模式，不管当前通道是什么模式。

     * 这个方法执行的安全检查与java.net.ServerSocket#accept方法一样。如果安全管理器已经安装，
     * 这个方法会验证每个新连接的地址和端口是安全管理器所允许的，
     * 此方法内部会调用java.lang.SecurityManager的checkAccept方法来完成检查
     */
            // 调用accept()方法后会阻塞等待客户端的连接，返回的socketChannel是处于阻塞模式的
            SocketChannel socketChannel = serverSocketChannel.accept();
            if(socketChannel==null){
                continue;
            }
            RandomAccessFile fromFile = new RandomAccessFile("d:\\fromFile.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(5);
            int byteRead = fromChannel.read(buf);
            while (byteRead!=-1){
                buf.flip();
                while (buf.hasRemaining()){
                    socketChannel.write(buf);
                }
                buf.clear();
                byteRead = fromChannel.read(buf);
            }

        }
    }



    @Test
    public void send() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        while(true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            if(socketChannel==null){
                continue;
            }
            ByteBuffer buf = ByteBuffer.allocate(50);
            buf.put("Chendongming".getBytes());
            buf.flip();
            socketChannel.write(buf);
        }
    }
}
