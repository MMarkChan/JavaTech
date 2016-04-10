package thread.projava8;

public class ThreadShare2 implements Runnable {
    private int sharedValue = 100;
    public static void main(String[] args) {
        ThreadShare2 ts = new ThreadShare2();
        Thread t1 = new Thread(ts);
        Thread t2 = new Thread(ts);
        t1.start();
        t2.start();
    }
    public void run() {
        sharedValue += 100;
        System.out.println("Value: " + sharedValue);
    }
}