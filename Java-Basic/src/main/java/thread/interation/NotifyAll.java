package thread.interation;

class Calculator extends Thread{
    int total;
    public void run() {
		synchronized (this) {
			for (int i = 0; i < 101; i++) {
				total += i;
			}
			
			//通知所有在此对象上等待的线程
			notifyAll();
		}
		
    } 
}

public class NotifyAll extends Thread{
	Calculator c;
    public NotifyAll(Calculator c) {
            this.c = c;
    }
    public void run() {
		synchronized (c) {
			try {
				System.out.println(Thread.currentThread() + "等待计算结果。。。");
				Thread.sleep(1000);
				c.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + "计算结果为：" + c.total);
		}
    }

    public static void main(String[] args) {
            Calculator calculator = new Calculator();
            //启动三个线程，分别获取计算结果
            new NotifyAll(calculator).start();
            new NotifyAll(calculator).start();
            new NotifyAll(calculator).start();
            //启动计算线程
            calculator.start();
    } 
    
    /**
     * 实际上，上面这个代码中，我们期望的是读取结果的线程在计算线程调用notifyAll()之前等待即可。 
     * 但是，如果计算线程先执行，并在读取结果线程等待之前调用了notify()方法，那么又会发生什么呢？
     * 这种情况是可能发生的。因为无法保证线程的不同部分将按照什么顺序来执行。
     * 幸运的是当读取线程运行时，它只能马上进入等待状态----它没有做任何事情来检查等待的事件是否已经发生。 
     *  ----因此，如果计算线程已经调用了notifyAll()方法，那么它就不会再次调用notifyAll()，
     *  ----并且等待的读取线程将永远保持等待。这当然是开发者所不愿意看到的问题。
     *  因此，当等待的事件发生时，需要能够检查notifyAll()通知事件是否已经发生。
     */
}
