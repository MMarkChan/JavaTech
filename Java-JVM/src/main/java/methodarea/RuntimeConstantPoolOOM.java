package methodarea;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args： -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * 使用JDK 1.7运行这段程序就不会得到相同的结果， while循环将一直进行下去。
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[]args) throws Throwable{
        // 使用List保持着常量池引用， 避免Full GC回收常量池行为
        List<String> list = new ArrayList();
        int i=0;
        while(true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
