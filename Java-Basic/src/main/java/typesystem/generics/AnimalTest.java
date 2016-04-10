package typesystem.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2016/3/14.
 */
public class AnimalTest {
    public static void main(String [] args){
//        List<? extends Animal> list = new ArrayList<>();
//        list.add(new Animal());
//        list.add(new Bird());
//        list.add(new Cat());

        List<? super Bird> list = new ArrayList<>();
        list.add(new Bird());
        list.add(new Magpie());
        /**
         * 我们可以这样看，把bird、magpie看成Bird对象，也可以将bird、magpie看成Animal对象，
         * 类似的可看成Object对象，最后发现这些添加到List<? super Bird> list里的对象都是同一类对象
         */
//        list.add(new Animal()); // error
        /**
         * 至于最后一行“list.add(new Animal())”是无法通过编译的，为了保护类型的一致性，
         * 因为“？ super Bird”可以是Animal，也可以是Object或其他Bird的父类，
         * 因无法确定其类型，也就不能往List<? super Bird>添加Bird的任意父类对象。

         既然无法确定其父类对象，那该如何遍历List<? super Bird> ? 因为Object是所有类的根类,
         所以可以用Object来遍历。如下，不过貌似其意义不大。

         for (Object object : list) {//...}
         */


        // This is completely legal
        String[] words = {"Hello World!"};
        Object[] objects = words;
        // Oh, dear, runtime error
        objects[0] = new Integer(42);


        Number num = new Integer(1);

//        ArrayList<Number> list1 = new ArrayList<Integer>(); //type mismatch

        List<? extends Number> list2 = new ArrayList<Number>();
//        list2.add(new Integer(1)); //error
//        list2.add(new Float(1.2f));  //error
        /**
         * List<? extends Number>表示存储的元素类型是Number的某一个子类型，包括Number自身
         * 此时定义这样一个类型的变量：
         * List<? extends Number> list = new ArrayList<Char>();
         * 因为list变量只声明了可以存储Number的子类实例，因此向里面添加整型和浮点型时，按理是很合理的
         * 但list实际上只能存储Char类型的元素，类型是不兼容的
         *
         * 传入的参数是未知的，所以java为了保护其类型一致，
         * 禁止向List<? extends Number>添加任意对象，不过却可以添加null，即list.add(null)是可行的。
         *
         * 在List<? extends Number> list里的都是Number对象，
         * 即Integer也是Number对象，Float也是Number对象（用java的语言来说就是子类可以指向父类，
         * 父类却不能指向子类），那么在Number里的所有方法都是可以调用的，如下：

         for (Number num : list) { num.byteValue(); }
         *
         * 因此，为了消除这种不兼容性，不应该对有上界的通配符所定义的集合执行添加元素操作，
         * 因为所添加的元素可能会与集合中实际能存储的元素类型不兼容
         */

        List<? super Number> list3 = new ArrayList<>();
        list3.add(new Integer(1));
        list3.add(new Float(1.2f));
        /**
         * List<? super Number>表示存储的元素的类型是Number的超类，包括Number自身
         * 此时定义这样一个类型的变量：
         * List<? super Number> list = new ArrayList<Object>();
         * 因为list变量声明了可以存储Number的父类对象，能够存储的最具体的子类元素是Number，
         * 因此向里面添加整型和浮点型数时，因为list实际上是存储Object类型的元素的
         * 因此list.add()方法中的参数是Object类型的，而整型和浮点型是Object的子类，此根据LSP替换原则：
         * 所有引用基类（父类）的地方必须能透明地使用其子类的对象。
         *
         *因此向list添加整型和浮点型数是与list中实际存储的元素类型是兼容的
         */


        List<? super MyFloat> list4 = new ArrayList<>();
        list4.add(new MyFloat());
        //list4.add(new MyNumber());

        List<String> l = new ArrayList<>();
        System.out.println(l);




    }

    static Number method(Number num) {
        return 1;
    }

//    Object result1 = method(new Integer(2)); //correct
//    Number result2 = method(new Object()); //error
//    Integer result3= method(new Integer(2)); //error
}
