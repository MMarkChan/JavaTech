package thread;

/**
 * 线程的让步含义就是使当前运行着线程让出CPU资源，但是然给谁不知道，仅仅是让出，线程状态回到可运行状态。
 * 
 * yield()应该做的是让当前运行线程回到可运行状态，
 * 以允许具有相同优先级的其他线程获得运行机会,注意：这里的其他也包含当前线程。。
 * 因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
 * 但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
 * @author Tom
 *
 */
public class Yield extends Thread {   
  public static void main(String[] args) { 
	  while(true){
		  new Yield().start(); 
	  }
  }   
  
  public void run() {
    System.out.println("1");
    yield();
    System.out.println("2");  
  }
}
