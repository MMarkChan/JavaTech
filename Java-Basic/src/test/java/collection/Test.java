package collection;


import collection.model.DelayedReminder;

import java.util.concurrent.DelayQueue;

/**
 * Created by Mark on 2016/3/11.
 */
public class Test {
    public static void main(String [] args){
        final DelayQueue queue = new DelayQueue();
        DelayedReminder reminder = new DelayedReminder("Wake me up in 60 seconds", 600);
        queue.add(reminder);
        reminder = new DelayedReminder("Wake me up in 30 seconds", 300);
        queue.add(reminder);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
