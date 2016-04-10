package findresources;

import org.junit.Test;

/**
 * Created by Mark on 2016/3/24.
 */
public class FindResources {
    @Test
    public void getResourceByClass(){
        /**
         查找与一个给定class关联的资源的规则由这个类的<定义类加载器>实现，这个方法会委托操作给
         它的类加载器。如果这个对象是由启动类加载器加载，则这个方法委托操作给ClassLoader.getSystemResource(java.lang.String)
         在委托操作之前，会使用以下算法对给定的资源名称构造一个绝对资源名称：
         1、如果名称以'/'('\u002f')开始,则这个资源的绝对名称取的是名称中跟在'/'后面的部分
         2、否则，绝对名称是以下形式：
            modified_package_name/name
            modified_package_name是由这个对象的包名把'.'替换为'/' ('\u002e')得来的.

         总结：都是由类加载器从类路径开始查找资源,资源名称前拼上类路径就是资源绝对路径
         */
        String path = this.getClass().getResource("/test.xml").getPath();
        System.out.println(path);
    }

    @Test
    public void getResourceByClassLoader(){
        /**
         * Finds the resource with the given name. A resource is some data
         * (images, audio, text, etc) that can be accessed by class code
         * in a way that is independent of the location of the code.
         The name of a resource is a '/'-separated path name that identifies
         the resource.

         This method will first search the parent class loader for the resource;
         if the parent is null the path of the class loader built-in to the
         virtual machine is searched. That failing, this method will invoke
         findResource(String) to find the resource.

         资源是某些可以被类代码以独立于代码位置的方式访问的数据（图片、音频、文本等等）。
         资源的名称是以'/'分割的路径名，它标识了这个资源

         这个方法会先向父类加载器查询这个资源，如果父加载器为null，则向虚拟机内置的类加载器路径查询。
         如果前面都找不到，则这个方法会调用findResource(String)方法来查找这个资源。

         实现findResource(String)方法的类加载器应该覆写此方法，指定从哪里查找资源

         注意：类加载器中的getResource()的参数不能以'/'开头
         */
        String path = this.getClass().getClassLoader().getResource("test.xml").getPath();
        System.out.println(path);
    }
}
