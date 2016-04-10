package collection.model;

import java.util.concurrent.Delayed;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Student implements Delayed {
    private int studentID;
    private String firstName;
    private String lastName;
    public Student(int id, String fname, String lname) {
        studentID = id;
        firstName = fname;
        lastName = lname;

    }
    public int getStudentID() {
        return studentID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public boolean equals(Object o) {
        boolean isEqual = false;
        if ((o != null) && (o instanceof Student)) {
            Student target = (Student)o;
            isEqual = (target.getStudentID() == this.getStudentID());
        }
        return isEqual;
    }

    public static void main(String [] args){
        final PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        System.out.println(queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                while (true){
                    queue.put(i);
                    i++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //System.out.println(i);
                }
            }
        }).start();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}