package thread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * 当一个类已经很好的同步以保护它的数据时，这个类就称为“线程安全的”。
 * 即使是线程安全类，也应该特别小心，因为操作的线程是间仍然不一定安全。
 * 举个形象的例子，比如一个集合是线程安全的，有两个线程在操作同一个集合对象，
 * 当第一个线程查询集合非空后，删除集合中所有元素的时候。
 * 第二个线程也来执行与第一个线程相同的操作，也许在第一个线程查询后，
 * 第二个线程也查询出集合非空，但是当第一个执行清除后，
 * 第二个再执行删除显然是不对的，因为此时集合已经为空了。
 *
 * @author Tom
 */
public class ThreadSafeClass {
    private List nameList = Collections.synchronizedList(new LinkedList());

    /**
     * public synchronized void add(String name)
     *
     * @param name
     */
    public void add(String name) {
        nameList.add(name);
    }

    /**
     * 解决上面问题的办法是，在操作集合对象的方法上面做一个同步。
     * public synchronized String removeFirst()
     *
     * @return
     */
    public String removeFirst() {
        if (nameList.size() > 0) {
            return (String) nameList.remove(0);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        final ThreadSafeClass nl = new ThreadSafeClass();
        nl.add("aaa");
        class NameDropper extends Thread {
            public void run() {
                String name = nl.removeFirst();
                System.out.println(name);
            }
        }

        Thread t1 = new NameDropper();
        Thread t2 = new NameDropper();
        t1.start();
        t2.start();
    }
}
