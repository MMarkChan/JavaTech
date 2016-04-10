package javaio;

import java.io.RandomAccessFile;

public class JumpInsertDemo{
    /**
     *
     * @param skip 跳过多少过字节进行插入数据
     * @param str 要插入的字符串
     * @param fileName 文件路径
     */
    public static void insert(long skip, String str, String fileName){
        try {
            RandomAccessFile raf = new RandomAccessFile(fileName,"rw");
            if(skip <  0 || skip > raf.length()){
                System.out.println("跳过字节数无效");
                return;
            }
            byte[] b = str.getBytes();
            // 先扩充文件到插入字符后的长度
            raf.setLength(raf.length() + b.length);
            // 把插入位置后的所有元素都向后移动b.length个位置
            for(long i = raf.length() - 1; i > b.length + skip - 1; i--){
                raf.seek(i - b.length); // 定位到需要被移动的元素，要移动的元素总是跟目标位置相差a.length
                byte temp = raf.readByte(); // 读取内容并暂存起来
                raf.seek(i); // 定位到移动目标位置
                raf.writeByte(temp); // 目标位置写入数据
            }
            raf.seek(skip); // 定位到需要插入的位置
            raf.write(b); // 写入插入内容
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String [] args){
        insert(3,"cdm","d:\\test.txt");
    }
}