package javaio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Mark on 2016/3/16.
 */
public class InputStreamAndOutputStream {
    @Test
    public void test(){
        try (InputStream is = new FileInputStream("/Users/ben/cluster.txt")) {
            byte[] buf = new byte[4096];
            int len, count = 0;
            while ((len = is.read(buf)) > 0) {
                for (int i=0; i<len; i++)
                    if (buf[i] == 97) count++;
            }
            System.out.println("'a's seen: "+ count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
