package thread.threadlocal;

/**
 * InheritableThreadLocal类是ThreadLocal类的子类。
 * ThreadLocal中每个线程拥有它自己的值，与ThreadLocal不同的是，
 * InheritableThreadLocal允许一个线程以及该线程创建的所有子线程都可以访问它保存的值。

 【注：所有子线程都会继承父线程保存的ThreadLocal值】
 */
public class InheritableThreadLocalExample {

    public static class MyRunnable implements Runnable {

        private ThreadLocal threadLocal = new InheritableThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            System.out.println(threadLocal.get());

            new Thread(){
                public void run(){
                    System.out.println(threadLocal.get());
                }
            }.start();
        }
    }

    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();
    }

}