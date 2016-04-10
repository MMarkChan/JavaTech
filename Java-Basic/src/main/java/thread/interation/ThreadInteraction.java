package thread.interation;

/**
 * 线程交互知识点需要从java.lang.Object的类的三个方法来学习：
 * void notify()
 * 	唤醒在此对象监视器上等待的单个线程。
 * void notifyAll()
 * 	 唤醒在此对象监视器上等待的所有线程，让所有在此对象上等待的线程冲出等待区，返回到可运行状态。
 * void wait()
 * 	导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法。
 * 
 * 
 * 关于等待/通知，要记住的关键点是：
 * 	必须从同步环境内调用wait()、notify()、notifyAll()方法。
 * 线程不能调用对象上等待或通知的方法，除非它拥有那个对象的锁。
 * 
 * 
 * 千万注意： 
 * 	当在对象上调用wait()方法时，执行该代码的线程立即放弃它在对象上的锁。
 * 	然而调用notify()时，并不意味着这时线程会放弃其锁。
 * 	如果线程依然在完成同步代码，则线程在移出之前不会放弃锁。
 * 	因此，只要调用notify()并不意味着这时该锁变得可用。
 * 
 * 
 * 
* 计算输出其他线程锁计算的数据
*
* 
*/
public class ThreadInteraction {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        //启动计算线程
        b.start();
        //线程A拥有b对象上的锁。线程为了调用wait()或notify()方法，该线程必须是那个对象锁的拥有者
        synchronized (b) {
            try {
                System.out.println("等待对象b完成计算。。。");
                //当前线程A等待
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b对象计算的总和是：" + b.total);
        }
    }
}

/**
* 计算1+2+3 ... +100的和
*
* @author leizhimin 2008-9-15 13:20:49
*/
class ThreadB extends Thread {
    int total;

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 101; i++) {
                total += i;
            }
            //（完成计算了）唤醒在此对象监视器上等待的单个线程，在本例中线程A被唤醒
            notify();
        }
    }
}
