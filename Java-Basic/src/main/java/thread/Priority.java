package thread;

/**
* Java线程：线程的调度-优先级
* 与线程休眠类似，线程的优先级仍然无法保障线程的执行次序。
* 只不过，优先级高的线程获取CPU资源的概率较大，优先级低的并非没机会执行。
* @author leizhimin 2009-11-4 9:02:40
*/
public class Priority {
        public static void main(String[] args) {
                Thread t1 = new MyThread1();
                Thread t2 = new Thread(new MyRunnable());
                t1.setPriority(10);
                t2.setPriority(1);

                t2.start();
                t1.start();
        }
}

class MyThread1 extends Thread {
        public void run() {
                for (int i = 0; i < 10; i++) {
                        System.out.println("线程1第" + i + "次执行！");
                        try {
                                Thread.sleep(100);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
        }
}

class MyRunnable implements Runnable {
        public void run() {
                for (int i = 0; i < 10; i++) {
                        System.out.println("线程2第" + i + "次执行！");
                        try {
                                Thread.sleep(100);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
        }
}