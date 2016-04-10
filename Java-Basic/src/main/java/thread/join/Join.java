package thread.join;

/**
 * 线程的合并的含义就是将几个并行线程的线程合并为一个单线程执行，
 * 应用场景是当一个线程必须等待另一个线程执行完毕才能执行时可以使用join方法。
 * @author Tom
 *
 */
public class Join {
	public static void main(String [] args) {
		Runnable r1= new Task1("r1");
		Thread t1 = new Thread(r1);
		Runnable r2= new Task2("r2",t1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("dddddddddddddd");
	}
}

class Task1 implements Runnable{
	private String name;
	public Task1(String name){
		this.name = name;
	}
	@Override
	public void run() {
		for(int i=0;i<5;i++)
			System.out.println(this.name+"-"+i);
		
	}
}

class Task2 implements Runnable{
	private String name;
	private Thread thread;
	public Task2(String name,Thread thread){
		this.name = name;
		this.thread = thread;
	}
	@Override
	public void run() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0;i<5;i++)
			System.out.println(this.name+"-"+i);
		
	}
}