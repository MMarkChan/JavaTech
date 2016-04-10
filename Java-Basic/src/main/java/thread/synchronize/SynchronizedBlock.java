package thread.synchronize;

/**
* Java线程：线程的同步
*
*对于同步，在具体的Java代码中需要完成一下两个操作： 
*	把竞争访问的资源标识为private； 
*	同步哪些修改变量的代码，使用synchronized关键字同步方法或代码。
*	当然这不是唯一控制并发安全的途径。
*
*	除了同步方法外，还可以使用同步代码块，有时候同步代码块会带来比同步方法更好的效果。
*	追其同步的根本的目的，是控制竞争资源的正确的访问，因此只要在访问竞争资源的时候保证同一时刻只能一个线程访问即可，
*	因此Java引入了同步代码快的策略，以提高性能。
* 
*/
public class SynchronizedBlock {
    public static void main(String[] args) {
        User2 u = new User2("张三", 100);
        MyThread2 t1 = new MyThread2("线程A", u, 20);
        MyThread2 t2 = new MyThread2("线程B", u, -60);
        MyThread2 t3 = new MyThread2("线程C", u, -80);
        MyThread2 t4 = new MyThread2("线程D", u, -30);
        MyThread2 t5 = new MyThread2("线程E", u, 32);
        MyThread2 t6 = new MyThread2("线程F", u, 21);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}

class MyThread2 extends Thread {
    private User2 u;
    private int y = 0;

    MyThread2(String name, User2 u, int y) {
        super(name);
        this.u = u;
        this.y = y;
    }

    public void run() {
        u.oper(y);
    }
}

class User2 {
    private String code;
    private int cash;

    User2(String code, int cash) {
	    this.code = code;
	    this.cash = cash;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 业务方法
     * @param x 添加x万元
     */
    public void oper(int x) {
        try {
            Thread.sleep(10L);
            synchronized (this) {
            	this.cash += x;
                System.out.println(Thread.currentThread().getName() + "运行结束，增加“" + x + "”，当前用户账户余额为：" + cash);
			}
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "User{" + "code='" + code + '\'' + ", cash=" + cash + '}';
    }
}

/**
 * 注意：
 * 通过前文可知，线程退出同步方法时将释放掉方法所属对象的锁，但还应该注意的是，
 * 同步方法中还可以使用特定的方法对线程进行调度。这些方法来自于java.lang.Object类。
 
	*void notify()    
                    唤醒在此对象监视器上等待的单个线程。    
	*void notifyAll()    
                    唤醒在此对象监视器上等待的所有线程。    
	*void wait()    
                    导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法。    
 	*void wait(long timeout)    
                    导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者超过指定的时间量。    
	*void wait(long timeout, int nanos)    
                    导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者其他某个线程中断当前线程，或者已超过某个实际时间量。
 
 
 在使用synchronized关键字时候，应该尽可能避免在synchronized方法或synchronized块中使用sleep或者yield方法，
 因为synchronized程序块占有着对象锁，你休息那么其他的线程只能一边等着你醒来执行完了才能执行。
 不但严重影响效率，也不合逻辑。同样，在同步程序块内调用yeild方法让出CPU资源也没有意义，因为你占用着锁，
 其他互斥线程还是无法访问同步程序块。当然与同步程序块无关的线程可以获得更多的执行时间。
 
 
 * 结合以上方法，处理多线程同步与互斥问题非常重要，
 * 著名的生产者-消费者例子就是一个经典的例子，任何语言多线程必学的例子。
 * */

