
package exception.error;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆内存溢出
 * VM Args： -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * 1、如果是内存泄露， 可进一步通过工具查看泄露对象到GC Roots的引用链。
 * 于是就能找到泄露对象是通过怎样的路径与GC Roots相关联并导致垃圾
 * 收集器无法自动回收它们的。 掌握了泄露对象的类型信息及GC Roots引用链
 * 的信息， 就可以比较准确地定位出泄露代码的位置。
 *
 * 2、如果不存在泄露， 换句话说， 就是内存中的对象确实都还必须存活着，
 * 那就应当检查虚拟机的堆参数（ -Xmx与-Xms） ， 与机器物理内存对比看是
 * 否还可以调大， 从代码上检查是否存在某些对象生命周期过长、 持有状态时
 * 间过长的情况， 尝试减少程序运行期的内存消耗。
 */
public class HeapOOM {
    static class OOMObject{}
    public static void main(String [] args){
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
