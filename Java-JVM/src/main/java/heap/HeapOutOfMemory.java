package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2016/3/24.
 */
public class HeapOutOfMemory {
    static class OOMObject{}
    /**
     *VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void main(String [] args){
        List<OOMObject> list = new ArrayList<OOMObject>();
        while(true) {
            list.add(new OOMObject());
        }
    }
}
