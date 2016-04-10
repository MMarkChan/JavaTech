package thread;

/**
 * 假设read()方法由一个线程启动，write()方法由另外一个线程启动。读线程将拥有resourceA锁，
 * 写线程将拥有resourceB锁，两者都坚持等待的话就出现死锁。
 * 实际上，上面这个例子发生死锁的概率很小。因为在代码内的某个点，CPU必须从读线程切换到写线程，所以，死锁基本上不能发生。
 * 但是，无论代码中发生死锁的概率有多小，一旦发生死锁，程序就死掉。
 * 有一些设计方法能帮助避免死锁，包括始终按照预定义的顺序获取锁这一策略。已经超出SCJP的考试范围。
 * @author Tom
 *
 */
public class DeadLock {
    private static class Resource {
        public int value;
    }

    private Resource resourceA = new Resource();
    private Resource resourceB = new Resource();

    public int read() {
        synchronized (resourceA) {
        	try {
        		// 暂停当前线程1秒，让resourceB的锁有大概率机会被其它线程获得
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            synchronized (resourceB) {
                return resourceB.value + resourceA.value;
            }
        }
    }

    public void write(int a, int b) {
        synchronized (resourceB) {
        	try {
        		// 暂停当前线程1秒，让resourceA的锁有大概率机会被其它线程获得
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            synchronized (resourceA) {
                resourceA.value = a;
                resourceB.value = b;
            }
        }
    } 
    
    public static class Task1 implements Runnable{
    	private DeadLock dl;
    	public Task1(DeadLock dl){
    		this.dl = dl;
    	}
		@Override
		public void run() {
			dl.read();
		}
    }
    
    public static class Task2 implements Runnable{
    	private DeadLock dl;
    	public Task2(DeadLock dl){
    		this.dl = dl;
    	}
		@Override
		public void run() {
			dl.write(3, 4);
		}
    }
    
    public static void main(String [] args){
    	DeadLock dl = new DeadLock();
    	Thread t1 = new Thread(new Task1(dl));
    	Thread t2 = new Thread(new Task2(dl));
    	t1.start();
    	t2.start();
    }
}
