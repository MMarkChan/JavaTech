package typesystem.generics;

/**
 * Created by Mark on 2016/3/14.
 */
public class MyNumber extends Number {

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}

class MyFloat extends MyNumber{}
