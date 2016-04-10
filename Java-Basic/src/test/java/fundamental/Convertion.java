package fundamental;

import org.junit.Test;

/**
 * Created by Mark on 2016/3/9.
 */
public class Convertion {

    @Test
    public void intConvert(){
        int n = 123456789;
        float f = n; // f is 1.23456792E8
        System.out.println(f);
    }

    @Test
    public void cast(){
        double x = 9.997;
        int nx = (int) x; // 9

        
        System.out.println(nx);
    }
}
