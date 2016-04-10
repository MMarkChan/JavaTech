package thread;
/**
 * 停止线程的正确方式，使用interrupted发送中断请求，在被停止线程中通过isInterrupted()检查中断位并做相应处理
 * 应用场景，t1正在执行自己的处理逻辑，t2可以随时请求让t1停止处理逻辑，但t1不能产生不完整的处理逻辑，
 * 这就是interrupt()方法的作用，它向t1发送中断请求，t1会在处理妥当后自行停止
 * @author Tom
 *
 */
public class StopThread2 {
	public static void main(String [] args) {
		TaskC ta = new TaskC();
		Thread t1 = new Thread(ta);
		Thread t2 = new Thread(new TaskD(t1));
		t1.start();
		t2.start();
	}
}

class TaskC implements Runnable {
	@Override
	public void run() {
		try{
			while (true) {
				System.out.println("Thread A");
				Thread.sleep(1000); // sleep()、wait()等会抛出中断异常的方法会在内部自己检查中断线程的中断状态，如果检查到线程中断状态被设置，则会抛出中断异常并重置中断状态，所以不需要使用isInterrupted()来检查中断状态
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

class TaskD implements Runnable{
	private Thread thread;
	public TaskD(Thread thread){
		this.thread = thread;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(4000);
			thread.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		while (!Thread.currentThread().isInterrupted()) {
//			System.out.println("Thread B");
//		}
	}
	
}
