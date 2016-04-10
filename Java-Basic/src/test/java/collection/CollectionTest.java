package collection;

import collection.model.*;

import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.PriorityBlockingQueue;
import org.testng.annotations.Test;
/**
 * Created by Mark on 2016/3/10.
 */
public class CollectionTest {


    @Test
    public void generic(){
        Collection<Student> collection = new ArrayList<>();
        //collection.add(new Integer (12345));

        Student student;
        Iterator<Student> iterator = collection.iterator();
        while (iterator.hasNext()) {
            student = iterator.next();
        }

        Random random = new Random();
        Collection<Integer> collection2 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            collection2.add(random.nextInt());
        }

        int total = 0;
        Iterator<Integer> iterator2 = collection2.iterator();
        while (iterator.hasNext()) {
            total += iterator2.next();
        }
    }

    @Test
    public void list(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(12345, "John", "Smith"));
        students.add(new Student(67890, "Jane", "Smith"));
        students.add(1, new Student(13579, "Adam", "Smith"));
        students.set(1, new Student(13580, "Adam2", "Smith2"));

        List<Student> list = new ArrayList<>();
        Student s1 = new Student(12345, "John", "Smith");
        Student s2 = new Student(12345, "John", "Smith");
        list.add(s1);
        list.remove(s2);
        System.out.println(list.size());

        List<String> list2 = new ArrayList<>();
        String test = "Testing";
        list2.add(test);
        list2.add(test);
        list2.add(null);
        System.out.println(list.size());


    }

    @Test
    public void set(){
     /*   Collection<StudentWithoutHashcode> collection = new HashSet<>();
        StudentWithoutHashcode s1 = new StudentWithoutHashcode(12345, "John", "Smith");
        StudentWithoutHashcode s2 = new StudentWithoutHashcode(67890, "Jane", "Smith");
        StudentWithoutHashcode s3 = new StudentWithoutHashcode(13579, "Adam", "Smith");
        StudentWithoutHashcode s4 = new StudentWithoutHashcode(67890, "Tom", "Jones");
        collection.add(s1);
        collection.add(s2);
        collection.add(s3);
        collection.add(s4);
        for (StudentWithoutHashcode student : collection) {
            System.out.println(student.getFullName());
        }*/


        Collection<StudentWithHashcode> collection2 = new HashSet<>();
        StudentWithHashcode s5 = new StudentWithHashcode(12345, "John", "Smith");
        StudentWithHashcode s6 = new StudentWithHashcode(67890, "Jane", "Smith");
        StudentWithHashcode s7 = new StudentWithHashcode(13579, "Adam", "Smith");
        StudentWithHashcode s8 = new StudentWithHashcode(67890, "Tom", "Jones");
        collection2.add(s5);
        collection2.add(s6);
        collection2.add(s7);
        collection2.add(s8);
        for (StudentWithHashcode student : collection2) {
            System.out.println(student.getFullName());
        }

        TreeSet<Integer> set = new TreeSet<>();
        set.add(new Integer (100));
        set.add(new Integer (50));
        set.add(new Integer (75));
        set.add(new Integer (0));
        for (Integer i : set) {
            System.out.println(i);
        }


        /*Collection<StudentComparable> collection = new TreeSet<>();
        StudentComparable s1 = new StudentComparable(12345, "John", "Smith");
        StudentComparable s2 = new StudentComparable(24680, "Jane", "Smith");
        StudentComparable s3 = new StudentComparable(13579, "Adam", "Smith");
        StudentComparable s4 =  new StudentComparable(67890, "Tom", "Jones");
        collection.add(s1);
        collection.add(s2);
        collection.add(s3);
        collection.add(s4);
        for (StudentComparable student : collection) {
            System.out.println(student.getFullName());
        }*/



        Collection<Student> collection = new TreeSet<>(new StudentComparator());
        Student s1 = new Student(12345, "John", "Smith");
        Student s2 = new Student(24680, "Jane", "Smith");
        Student s3 = new Student(13579, "Adam", "Smith");
        Student s4 = new Student(67890, "Tom", "Jones");
        collection.add(s1);
        collection.add(s2);
        collection.add(s3);
        collection.add(s4);
        for (Student student : collection) {
            System.out.println(student.getStudentID() + " " + student.getFullName());
        }

        EnumSet<DayOfWeek> schoolDays = EnumSet.of(DayOfWeek.Monday, DayOfWeek.Tuesday,
                DayOfWeek.Wednesday, DayOfWeek.Thursday, DayOfWeek.Friday);
        schoolDays.add(DayOfWeek.Saturday);

        for (DayOfWeek day : schoolDays) {
            System.out.println(day);
        }

        HashMap<Integer,Student> map = new HashMap<>();

       /* Student s1 = new Student(12345, "John", "Smith");
        Student s2 = new Student(24680, "Jane", "Smith");
        Student s3 = new Student(13579, "Adam", "Smith");
        Student s4 = new Student(67890, "Tom", "Jones");
        map.put(s1.getStudentID(), s1);
        map.put(s2.getStudentID(), s2);
        map.put(s3.getStudentID(), s3);
        map.put(s4.getStudentID(), s4);*/

        Student student;
        Set<Integer> keys = map.keySet();
        for (Integer i : keys) {
            student = map.get(i);
            System.out.println("Key: " + i + " Value:" + student.getFullName());
        }

        //Integer i = 8;
        //System.out.println(i.hashCode());

        IdentityHashMap<Integer,Student> map2 = new IdentityHashMap<>();
        map2.put(new Integer (123), null);
        map2.put(new Integer (123), null);
        for (Integer i : map2.keySet()) {
            System.out.println(i);
        }


    }


    @Test
    public void identityHashMap(){
        IdentityHashMap<Integer,Student> map = new IdentityHashMap<>();
        Student s1 = new Student(12345, "John", "Smith");
        map.put(s1.getStudentID(), s1);
        map.put(s1.getStudentID(), s1);
        for (Student s : map.values()) {
            System.out.println(s.getStudentID() + " " + s.getFullName());
        }

        System.out.println(s1.getStudentID()==s1.getStudentID());
    }

    @Test
    public void weakHashMap(){
        WeakHashMap<Integer,Student> map = new WeakHashMap<>();
        Student s1 = new Student(12345, "John", "Smith");
        Student s2 = new Student(24680, "Jane", "Smith");
        Student s3 = new Student(13579, "Adam", "Smith");
        Student s4 = new Student(67890, "Tom", "Jones");
        map.put(s1.getStudentID(), s1);
        map.put(s2.getStudentID(), s2);
        map.put(s3.getStudentID(), s3);
        map.put(s4.getStudentID(), s4);
        System.out.println("The map initially contained " + map.size() + " entries");
        System.gc();
        System.out.println("The map now contains " + map.size() + " entries");
    }

    @Test
    public void blockingQueue(){
        final PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(queue.poll());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                while (true){
                    //queue.put(i);
                    i++;
                    System.out.println(i);
                }
            }
        }).start();
    }

    @Test
    public void delayedQueue(){
        final DelayQueue queue = new DelayQueue();
        DelayedReminder reminder = new DelayedReminder("Wake me up in 60 seconds", 6000);
        queue.add(reminder);
        reminder = new DelayedReminder("Wake me up in 30 seconds", 3000);
        queue.add(reminder);

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
    }

    @Test
    public void streamAPI(){
        Collection<String> myItems = new ArrayList<>();
        myItems.add("a8A8");
        myItems.add("a9A9");
        myItems.add("b8A8");
        myItems.add("b9A9");
        myItems.add("b9A9");
        //List<String> filteredList =
                myItems.stream() // 数据源
//                        .filter(item -> item.startsWith("a")) // 中间操作
//                        .filter(item -> item.endsWith("9")) // 中间操作
                        .limit(2)
                        .map(item -> item.toLowerCase()) // 中间操作
                        .distinct()
                        .forEach(t->System.out.println(t));
                        //.collect(Collectors.toList()); // 最终操作

       // System.out.println(filteredList);



//        // This anonymous inner class is equivalent to the lambda: item -> (item.startsWith(prefix))
//        Predicate<String> prefixSelector = new Predicate<String>() {
//            public boolean test(String candidate) {
//                return candidate.startsWith("a");
//            }
//        };
//        Stream<String> dataSource = myItems.stream();
//        Stream<String> filtered = dataSource.filter(prefixSelector);
//        Collector<String, ?, List<String>> collector = Collectors.toList();
//        List<String> myList = filtered.collect(collector);
    }
}
