package proxy.dynamicproxy.jdkinterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 生成动态代理对象的工厂.
 */
public class DynProxyFactory {
    //客户类调用此工厂方法获得代理对象。
    //对客户类来说，其并不知道返回的是代理类对象还是委托类对象。
    public static Subject getInstance(){
        Subject delegate = new RealSubject();
        InvocationHandler handler = new SubjectInvocationHandler(delegate);
        Subject proxy = (Subject) Proxy.newProxyInstance(
                // 使用与加载真实对象类型相同的类加载器来加载动态生成的代理类
                delegate.getClass().getClassLoader(),
                // 生成的代理类需要实现的接口
                delegate.getClass().getInterfaces(),
                // 代理类在被调用时，与真实类对接起来的处理器，
                // 也就是把对动态代理对象的方法对象与真实对象中的相应方法进行映射起来的对象
                handler);
        return proxy;
    }
}
