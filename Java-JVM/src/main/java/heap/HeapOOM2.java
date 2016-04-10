package heap;

/**
 * 上面这段代码的内存耗尽异常是由于不断在堆中创建线程对象而出现的，因为堆不像栈，
 * 堆是更像是无序的放置，没有所谓的Overflow一说，而栈是自下向上进行叠加，
 * 达到顶（由-Xss指定）时就会溢出，因此有Overflow一说；
    因此，堆的空间不足异常是OutOfMemoryError，而栈的空间不足是StackOverflowError。
 并不是像《深入理解Java虚拟机》这本书中111页所说的：

 “这里把异常分成两种情况， 看似更加严谨， 但却存在着一些互相重叠的
 地方： 当栈空间无法继续分配时， 到底是内存太小， 还是已使用的栈空间太
 大， 其本质上只是对同一件事情的两种描述而已。
 在笔者的实验中， 将实验范围限制于单线程中的操作， 尝试了下面两种
 方法均无法让虚拟机产生OutOfMemoryError异常， 尝试的结果都是获得
 StackOverflowError异常”

 因为栈才有Overflow错误，这很容易理解
 */

/**
 * VM Args： -Xss2M
 *
 * 警告：在Windows平台的虚拟机中， Java的线程是映射到操作系统的内核线程上的[1]，
 * 因此支行下面的代码时有较大的风险， 可能会导致操作系统假死。
 */
public class HeapOOM2{
    private void dontStop() {
        while(true) {}
    }
    public void stackLeakByThread() {
        while(true){
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
    public static void main(String[]args) throws Throwable{
        HeapOOM2 oom=new HeapOOM2();
        oom.stackLeakByThread();
    }
}