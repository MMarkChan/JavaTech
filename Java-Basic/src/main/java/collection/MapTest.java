package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mark on 2016/1/10.
 */
public class MapTest {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"tom");
        String original = map.put(1,"mark");
        original = map.put(2,"ddd");
        System.out.println(original);
        Collection c = new ArrayList<>();
    }
}
