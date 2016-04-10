package fundamental;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import static java.lang.Math.*;

/**
 * Created by Mark on 2016/3/9.
 */
public class Operator {
    @Test
    public void moudule(){
        // 整数除以0会抛出异常java.lang.ArithmeticException
        //int integerDividedByZero = 6/0;
        // 浮点数除以0会得到无穷或NaN,此处结果为Infinity
        double doubleDividedByZero = 6.0/0;
        System.out.println(doubleDividedByZero);
    }

    @Test
    public void bitwise(){
        int n = 100;
        int fourthBitFromRight = (n & 0b1000) / 0b1000;
        System.out.println(fourthBitFromRight);

        fourthBitFromRight = (n & (1 << 3)) >> 3;

        int r1 = 1 << 35;
        int r2 = 1 <<3;
        System.out.println(r1);
        System.out.println(r2);
    }

    @Test
    public void pow(){
        double pow = Math.pow(2,3);
        System.out.print(pow);
    }
}
