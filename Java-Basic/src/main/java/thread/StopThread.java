package thread;
/**
 * ֹͣ�̵߳���ȷ��ʽ��ʹ��interrupted�����ж������ڱ�ֹͣ�߳���ͨ��isInterrupted()����ж�λ������Ӧ����
 * Ӧ�ó�����t1����ִ���Լ��Ĵ����߼���t2������ʱ������t1ֹͣ�����߼�����t1���ܲ����������Ĵ����߼���
 * �����interrupt()���������ã�����t1�����ж�����t1���ڴ����׵�������ֹͣ
 * @author Tom
 *
 */
public class StopThread {
	public static void main(String [] args) {
		TaskA ta = new TaskA();
		Thread t1 = new Thread(ta);
		Thread t2 = new Thread(new TaskB(t1));
		t1.start();
		t2.start();
	}
}

class TaskA implements Runnable {
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("Thread A");
		}
	}
}

class TaskB implements Runnable{
	private Thread thread;
	public TaskB(Thread thread){
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
