package javanio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Mark on 2016/3/18.
 */
public class BufferTest {

    /**
     * 当向buffer写入数据时，buffer会记录下写了多少数据。
     * 一旦要读取数据，需要通过flip()方法将Buffer从写模式切换到读模式。
     * 在读模式下，可以读取之前写入到buffer的所有数据。
     *
     * 一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。
     * 有两种方式能清空缓冲区：调用clear()或compact()方法。
     * clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。
     * 任何未读的数据都被移到缓冲区的起始处，
     * 新写入的数据将放到缓冲区未读数据的后面。
     * @throws IOException
     */
    @Test
    public void basicUse() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        //create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf); //read into buffer.
        while (bytesRead != -1) {

            buf.flip();  //make buffer ready for read

            while(buf.hasRemaining()){
                System.out.print((char) buf.get()); // read 1 byte at a time
            }

            buf.clear(); //make buffer ready for writing
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
