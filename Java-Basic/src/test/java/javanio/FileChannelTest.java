package javanio;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Mark on 2016/3/18.
 */
public class FileChannelTest {
    @Test
    public void fileChannel() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("d:\\abc.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            //翻转。limit设置为当前位置，position则设置为0，如果设置了标记位，则把标记位废弃
            buf.flip();

            //当前position和limit之前是否还有元素
            while(buf.hasRemaining()){
                // 因为刚读取数据到buf，而重置position=0,limit=之前最后写入数据的位置，则buf的0-48之间肯定有数据
                System.out.print((char) buf.get());
            }

            buf.clear(); // 清除buf
            bytesRead = inChannel.read(buf);
        }
        aFile.close();

    }
}
