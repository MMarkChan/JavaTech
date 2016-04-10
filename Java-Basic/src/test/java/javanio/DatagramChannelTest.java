package javanio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by Mark on 2016/3/18.
 */
public class DatagramChannelTest {
    @Test
    public void receive() throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(80));
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();


        /**
         * 如果数据报立即可用，或者这个通道是阻塞模式且最终有一个可用，则数据报会被复制到字节缓存中，
         * 且数据报的来源地址会被返回来。如果这个通道处于非阻塞模式且数据报不是立即可用的，则这个方法会马上返回null
         *
         * 数据报被传输到字节缓存中，从字节缓存的当前position开始，如果字节缓存的剩余空间不足以存储全部数据报
         * ，则数据报剩下的内容会被丢掉。
         *
         * 此方法执行与java.net.DatagramSocket的receive方法一样的安全检查。如果socket不与特定的主机连接在一起，
         * 且安全管理器已经安装，则会对这个方法所接收的每一个数据报的来源地址和端口号进行验证，看是否允许，这是通过调用
         * java.lang.SecurityManager的checkAccept方法来完成的。这种安全检查的开销可以通过先用socket的connect方法来连接来消除
         *
         * 这个方法可以在任何时候调用。如果另一个线程已经在这个通道上触发了一个读取操作，则这个方法调用会一直阻塞，
         * 直到第一个操作完成。如果这个通道的socket没有绑定，则个方法会导致这个socket被绑定到一个自动分配的址上，
         * 就如同调用了bind方法传入了参数一样。
         */
        channel.receive(buf);
        buf.flip();
        System.out.print(new String(buf.array()));


    }

    @Test
    public void send() throws Exception {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));
        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();

        int bytesSent = channel.send(buf, new InetSocketAddress("127.0.0.1", 80));
    }
}
