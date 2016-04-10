package thread;

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
            System.out.print(Thread.currentThread().getName()); // 先打印出A 
            t.interrupt();  // 设置B的阻塞中断位，让B线程得以运行
            try {  
                this.join();  // A线程等待主线程执行完
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
                this.join(); // 调用join()后，本线程进入阻塞状态，等待主线执行完 
                  
            } catch (InterruptedException e) {  
                  
            }  
            Thread.currentThread().isInterrupted();
            System.out.print(Thread.currentThread().getName()); // 阻塞状态被中断后执行这一行 
            t.interrupt();  // 中断其它的阻塞
        }  
    }  
}  