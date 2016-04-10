package javanio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelTest {
    @Test
    public void transferFrom() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("d:\\fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("d:\\toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();
        long position = 0;
        long count = fromChannel.size();
        toChannel.transferFrom(fromChannel,position, count);
    }

    @Test
    public void transferTo() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("d:\\fromFile.txt", "rw");
        FileChannel      fromChannel = fromFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("d:\\toFile.txt", "rw");
        FileChannel      toChannel = toFile.getChannel();
        long position = 0;
        long count = fromChannel.size();
        fromChannel.transferTo(position, count, toChannel);
    }
}
