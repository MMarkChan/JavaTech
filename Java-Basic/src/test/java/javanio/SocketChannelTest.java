package javanio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Mark on 2016/3/18.
 */
public class SocketChannelTest {
    @Test
    public void read() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));

        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = socketChannel.read(buf);
        while (bytesRead!=-1){
            // 没有到文件尾部，buf切换到读取模式
            buf.flip();
            while(buf.hasRemaining()){
                System.out.println((char)buf.get());
            }
            // 重置buf的position和limit，以便可以重新写入48字节
            buf.clear();
            bytesRead = socketChannel.read(buf);
        }

        socketChannel.close();

    }

    @Test
    public void write() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));

        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());

        buf.flip();

        while(buf.hasRemaining()) {
            socketChannel.write(buf);
        }


        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));

        while(! socketChannel.finishConnect() ){
            //wait, or do something else...
        }
    }
}
