package thread.thunder;

/**
 * 思路：
 * 使用同步原理
 * 用来同步的对象维护一个有顺的条件，只有各个线程满足这个条件时，才能打印自身的内容，否则让出锁让其它线程执行
 * 满足条件的线程每打印一次自身内容后都会改变对象的有顺条件
 */
public class PrintABC {
    public static void main(String[] args) {
        MajusculeABC maj = MajusculeABC.newInstance();
        Thread t_a = new Thread(new Thread_ABC(maj , 'A'));
        Thread t_b = new Thread(new Thread_ABC(maj , 'B'));
        Thread t_c = new Thread(new Thread_ABC(maj , 'C'));
        t_a.start();
        t_b.start();
        t_c.start();
    }
}

class MajusculeABC {
    private char charactor = 'A';

    /* 限制此类只创建一个对象 */
    private static MajusculeABC maObj =null;
    private MajusculeABC() {}
    public static MajusculeABC newInstance(){
        if(maObj == null) {
            maObj = new MajusculeABC();
        }
        return maObj;
    }

    /**
     * 这是一个有顺的条件
     */
    public void setCharactor() {
        this.charactor += 1;
        if(this.charactor == 'D') {
            this.charactor = 'A';
        }
    }
    public char getCharactor() {
        return this.charactor;
    }

}

class Thread_ABC implements Runnable {

    private MajusculeABC maj;
    private char charactor = ' ';

    public Thread_ABC(MajusculeABC maj, char charactor) {
        this.maj = maj;
        this.charactor = charactor;
    }

    public void run() {
        int i = 0;
        while (i<10) {
            synchronized (maj) {

                while(this.charactor != maj.getCharactor()) {
                    try {
                        // 当前线程内部的charactor属性值与同步对象的charactor属性不相等时则让出同步锁（通过调用同步对象的wait()方法）
                        maj.wait();
                        // 当被阻塞线程被通知同步锁可以竞夺并成功获得同步锁，
                        // 再次进入此同步块并恢复线程栈到此处时，
                        // 需要再次判断当前线程内部的charactor属性值与同步对象的charactor属性
                    } catch (InterruptedException e) {}
                }

                // 当前线程内部的charactor属性值与同步对象的charactor属性相同，
                // 打印当前线程的内容，并改变同步对象的charactor属性值，
                // 然后让系统通知所有因等待同步对象锁而阻塞的线程
                System.out.print(this.charactor);
                i++;
                maj.setCharactor();
                maj.notifyAll();

            }
        }

    }
}