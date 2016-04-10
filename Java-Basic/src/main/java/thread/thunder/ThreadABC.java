package thread.thunder;

/**
 * 思路：
 * 线程ta打印10次A，tb打印10次B，tc打印10次C，td打印10次D
 * ta每打印一次A都要让tb打印一次B，
 * tb每打印一次B都要让tc打印一次C，
 * tc每打印一次C都要让td打印一次D，
 * td每打印一次D都要让ta打印一次A
 *
 * 当所有线程得到CPU时间运行时，除了ta所有其它线程都会因为调用了自身的join()而进入等待状态，直至其它线程设置了它们的中断位，
 * 正在等待的线程检查到中断位为true，则抛了中断异常，由于异常被捕获了，所以后面打印线程名称的语句会正常执行。
 *
 * 就拿循环的第一遍来说：
 * 首先ta打印了A，接着调用了tb.interrupt()中断了tb，并调用this.join()让自己无限等待，等待被别的线程中断以进入下一轮执行
 * tb接收到中断信号并捕获异常后打印自己的线程名称，然后调用tc.interrupt()中断了tc,并调用this.join()让自己无限等待，等待被别的线程中断以进入下一轮执行
 * tc接收到中断信号并捕获异常后打印自己的线程名称，然后调用td.interrupt()中断了td, 并调用this.join()让自己无限等待，等待被别的线程中断以进入下一轮执行
 * td接收到中断信号并捕获异常后打印自己的线程名称，然后调用ta.interrupt()中断了ta, 并调用this.join()让自己无限等待，等待被别的线程中断以进入下一轮执行
 */
public class ThreadABC {
    public static void main(String[] args) {
        Thread_E tc = new Thread_E();
        Thread_E tb = new Thread_E();
        Thread_E td = new Thread_E();
        Thread_A ta = new Thread_A();

        ta.setThread(tb);
        tb.setThread(tc);
        tc.setThread(td);
        td.setThread(ta);

        ta.setName("A");
        tb.setName("B");
        tc.setName("C");
        td.setName("D");

        ta.start();
        tb.start();
        tc.start();
        td.start();

    }
}

class Thread_A extends Thread {
    Thread t;
    public void setThread(Thread t) {
        this.t = t;
    }
    public void run() {
        int i = 0;
        while(i++ < 10) {
            System.out.print(Thread.currentThread().getName());
            t.interrupt();
            try {
                // 调用this.join()导致当前线程阻塞，也就是说当前线程要等待自身死亡，
                // 导致进入无限等待的死循环中，必须要通过其它线程对它进行中断，此处的其它线程就是线程tb
                this.join();
            } catch (InterruptedException e) {

            }
        }
    }
}

class Thread_E extends Thread {
    Thread t;
    public void setThread(Thread t) {
        this.t = t;
    }
    public void run() {
        int i = 0;
        while(i++ < 10) {
            try {
                this.join();

            } catch (InterruptedException e) {

            }
            System.out.print(Thread.currentThread().getName());
            t.interrupt();
        }
    }
}
