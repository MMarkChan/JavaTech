package thread.join;

/**
 * Created by Mark on 2016/3/17.
 */
public class SelfJoin {
    public static void main(String [] args) throws InterruptedException {
       Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    this.join();
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
                System.out.println("已被中断！！");
            }
        };
        t.start();
        Thread.sleep(10000);

        t.interrupt();
    }
}
