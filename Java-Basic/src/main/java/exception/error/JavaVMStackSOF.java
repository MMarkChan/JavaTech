package exception.error;

/**
 * VM Args： -Xss128k
 * 对于HotSpot来说， 虽然-Xoss参数（ 设置本地方法栈大小） 存在，
 * 但实际上是无效的， 栈容量只由-Xss参数设定。 关于虚拟机栈和本地方法栈，
 * 在Java虚拟机规范中描述了两种异常：
 * 1、如果线程请求的栈深度大于虚拟机所允许的最大深度， 将抛出StackOverflowError异常。
 * 2、如果虚拟机在扩展栈时无法申请到足够的内存空间， 则抛出OutOfMemoryError异常。
 *
 * 实验结果表明： 在单个线程下， 无论是由于栈帧太大还是虚拟机栈容量太小，
 * 当内存无法分配的时候， 虚拟机抛出的都是StackOverflowError异常。
 *
 * 虚拟机提供了参数来控制Java堆和方法区的这两部分内存的最大值。
 * 剩余的内存为2GB（ 操作系统限制） 减去Xmx（ 最大堆容量） ，
 * 再减去MaxPermSize（ 最大方法区容量） ， 程序计数器消耗内存很小， 可以忽略掉。
 * 如果虚拟机进程本身耗费的内存不计算在内， 剩下的内存就由虚拟机栈和本地方法栈“瓜分”了。
 * 每个线程分配到的栈容量越大， 可以建立的线程数量自然就越少， 建立线程时就越容易把剩下的内存耗尽。
 */
public class JavaVMStackSOF {
    private int stackLength=1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[]args) throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{
            oom.stackLeak();
        }catch(Throwable e) {
            System.out.println("stack length： "+oom.stackLength);
            throw e;
        }
    }
}
