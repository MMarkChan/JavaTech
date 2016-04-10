package proxy.dynamicproxy.cglib;

/**
 * 程序猿类
 * cglib 通过类继承生成动态代理类
 *
 * cglib 创建某个类A的动态代理类的模式是：

 1. 查找A上的所有非final 的public类型的方法定义；

 2.将这些方法的定义转换成字节码；

 3.将组成的字节码转换成相应的代理的class对象；

 4.实现 MethodInterceptor接口，用来处理 对代理类上所有方法的请求
 （这个接口和JDK动态代理InvocationHandler的功能和角色是一样的）

 */
public class Programmer {

    public void code()
    {
        System.out.println("I'm a Programmer,Just Coding.....");
    }
}